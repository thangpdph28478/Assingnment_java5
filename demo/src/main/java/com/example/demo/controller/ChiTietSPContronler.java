package com.example.demo.controller;

import com.example.demo.model.ChiTietSP;
import com.example.demo.model.ChiTietSP;
import com.example.demo.model.DongSP;
import com.example.demo.model.MauSac;
import com.example.demo.model.NSX;
import com.example.demo.model.SanPham;
import com.example.demo.service.ChiTietSPService;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.CuaHangService;
import com.example.demo.service.ChiTietSPService;
import com.example.demo.service.DongSPService;
import com.example.demo.service.MauSacService;
import com.example.demo.service.NSXService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/chi-tiet-sp")
public class ChiTietSPContronler {

    @Autowired
    private ChiTietSPService service;
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private NSXService nsxService;
    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private DongSPService dongSPService;

    @GetMapping("/hien-thi")
    public String hienThi(
            Model model,
//            @ModelAttribute("chucVu") ChucVu chucVu,
            @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {

        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<ChiTietSP> page = service.getAll(pageable);
        model.addAttribute("tbt", service.getAll1());
        model.addAttribute("dulieu", page.getContent()); //danh sách list trong trang
        model.addAttribute("total", page.getTotalPages()); // tổng số trang(trang đếm từ 0)

        model.addAttribute("noisanxuat", nsxService.getAll1());
        model.addAttribute("sanpham", sanPhamService.getAll1());
        model.addAttribute("mausac", mauSacService.getAll1());
        model.addAttribute("dongsanpham", dongSPService.getAll1());
        return "trang-home-ChiTietSP";
    }


    @GetMapping("/remove/{id}")

    public String remove(Model model,
                         @PathVariable("id") UUID id

    ) {
        service.delete(id);
        return "redirect:/chi-tiet-sp/hien-thi";
    }


    @GetMapping("/view-update/{id}")

    public String viewUpdate(Model model,
                             @PathVariable("id") UUID id

    ) {
        System.out.println(id);
        ChiTietSP sp = service.getOne(id);
        model.addAttribute("dulieuxem", sp);
        model.addAttribute("chucvu", chucVuService.getAll1());
        model.addAttribute("cuahang", cuaHangService.getAll1());
        model.addAttribute("tbt", service.getAll1());
        model.addAttribute("noisanxuat", nsxService.getAll1());
        model.addAttribute("sanpham", sanPhamService.getAll1());
        model.addAttribute("mausac", mauSacService.getAll1());
        model.addAttribute("dongsanpham", dongSPService.getAll1());
        return "trang-update-ChiTietSP";
    }


    @PostMapping("/update/{id}")
    public String updateChucVu(Model model,
                               @PathVariable("id") UUID id,
                               @ModelAttribute("dulieuxem") ChiTietSP nhanVien  // dùng form string
    ) {
        ChiTietSP sp = service.getOne(id);

        BeanUtils.copyProperties(nhanVien, sp);
        // vt1: bên form
        // vt2:của get one


        service.ADDvsUPDATE(sp);
        return "redirect:/chi-tiet-sp/hien-thi";
    }


    @GetMapping("/view-add")

    public String viewadd(Model model,
                          @ModelAttribute("dulieuxem") ChiTietSP nhanVien //vif dungf from string dulieuthem been add neu ko co dong ny se loi


    ) {
        // dong 107,108,109 dùng check radio chọn 1 trong 2, chứ sping form radio ko dc dung checked.đậu xanh
//        nhanVien.setGioiTinh("Nam");

        model.addAttribute("dulieuxem", nhanVien);
        //
        model.addAttribute("tbt", service.getAll1());
        model.addAttribute("chucvu", chucVuService.getAll1());
        model.addAttribute("cuahang", cuaHangService.getAll1());
        model.addAttribute("noisanxuat", nsxService.getAll1());
        model.addAttribute("sanpham", sanPhamService.getAll1());
        model.addAttribute("mausac", mauSacService.getAll1());
        model.addAttribute("dongsanpham", dongSPService.getAll1());
        return "trang-add-ChiTietSP";
    }


    @PostMapping("/add")
    public String updateadd(Model model,
                            @ModelAttribute("dulieuxem") ChiTietSP nhanVien  // dùng form string
    ) {


        service.ADDvsUPDATE(nhanVien);
        return "redirect:/chi-tiet-sp/hien-thi";
    }


    @PostMapping("/timkiem")
    public String timkiem(Model model,
                          @RequestParam("tenTK") String ten,
                          @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
                          @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {
//tim
        List<ChiTietSP> dulieuTK = service.search(ten);
        model.addAttribute("dulieu", dulieuTK);

//phan trang
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<ChiTietSP> page = service.getAll(pageable);
//        model.addAttribute("dulieu", page.getContent()); //danh sách list trong trang
        model.addAttribute("total", page.getTotalPages()); // tổng số trang(trang đếm từ 0)
        model.addAttribute("noisanxuat", nsxService.getAll1());
        model.addAttribute("sanpham", sanPhamService.getAll1());
        model.addAttribute("mausac", mauSacService.getAll1());
        model.addAttribute("dongsanpham", dongSPService.getAll1());

        //code tìm phải có code phân trang vì return về trang (  return "trang-home-ChiTietSP";) chu ko phai link
        //neu return về kink  (return "redirect:/chi-tiet-sp/hien-thi";) sẽ trôi tìm kiếm
        return "trang-home-ChiTietSP";
//        return "redirect:/chi-tiet-sp/hien-thi";
    }

}

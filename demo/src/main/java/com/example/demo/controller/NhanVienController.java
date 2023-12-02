package com.example.demo.controller;

import com.example.demo.model.ChucVu;
import com.example.demo.model.NhanVien;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.CuaHangService;
import com.example.demo.service.NhanVienService;
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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {


    @Autowired
    private NhanVienService service;
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/hien-thi")
    public String hienThi(
            Model model,
//            @ModelAttribute("chucVu") ChucVu chucVu,
            @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {

        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<NhanVien> page = service.getAll(pageable);
        model.addAttribute("tbt", service.getAll1());
        model.addAttribute("dulieu", page.getContent()); //danh sách list trong trang
        model.addAttribute("total", page.getTotalPages()); // tổng số trang(trang đếm từ 0)
        return "trang-home-NhanVien";
    }


    @GetMapping("/remove/{id}")

    public String remove(Model model,
                         @PathVariable("id") UUID id

    ) {
        service.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }


    @GetMapping("/view-update/{id}")

    public String viewUpdate(Model model,
                             @PathVariable("id") UUID id

    ) {
        System.out.println(id);
        NhanVien sp = service.getOne(id);
        model.addAttribute("dulieuxem", sp);
        model.addAttribute("chucvu", chucVuService.getAll1());
        model.addAttribute("cuahang", cuaHangService.getAll1());
        model.addAttribute("tbt", service.getAll1());
        return "trang-update-NhanVien";
    }


    @PostMapping("/update/{id}")
    public String updateChucVu(Model model,
                               @PathVariable("id") UUID id,
                               @ModelAttribute("dulieuxem") NhanVien nhanVien  // dùng form string
    ) {
        NhanVien sp = service.getOne(id);

        BeanUtils.copyProperties(nhanVien, sp);
        // vt1: bên form
        // vt2:của get one


        service.ADDvsUPDATE(sp);
        return "redirect:/nhan-vien/hien-thi";
    }


    @GetMapping("/view-add")

    public String viewadd(Model model,
                          @ModelAttribute("dulieuxem") NhanVien nhanVien //vif dungf from string dulieuthem been add neu ko co dong ny se loi


    ) {
        // dong 107,108,109 dùng check radio chọn 1 trong 2, chứ sping form radio ko dc dung checked.đậu xanh
//        nhanVien.setGioiTinh("Nam");
        nhanVien.setTrangThai(1);
        model.addAttribute("dulieuxem", nhanVien);
        //
        model.addAttribute("tbt", service.getAll1());
        model.addAttribute("chucvu", chucVuService.getAll1());
        model.addAttribute("cuahang", cuaHangService.getAll1());

        return "trang-add-NhanVien";
    }


    @PostMapping("/add")
    public String updateadd(Model model,
                            @ModelAttribute("dulieuxem") NhanVien nhanVien  // dùng form string
    ) {


        service.ADDvsUPDATE(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }


    @PostMapping("/timkiem")
    public String timkiem(Model model,
                          @RequestParam("tenTK") String ten,
                          @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
                          @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {
//tim
        List<NhanVien> dulieuTK = service.search(ten);
        model.addAttribute("dulieu", dulieuTK);

//phan trang
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<NhanVien> page = service.getAll(pageable);
//        model.addAttribute("dulieu", page.getContent()); //danh sách list trong trang
        model.addAttribute("total", page.getTotalPages()); // tổng số trang(trang đếm từ 0)


        //code tìm phải có code phân trang vì return về trang (  return "trang-home-NhanVien";) chu ko phai link
        //neu return về kink  (return "redirect:/nhan-vien/hien-thi";) sẽ trôi tìm kiếm
        return "trang-home-NhanVien";
//        return "redirect:/nhan-vien/hien-thi";
    }


}



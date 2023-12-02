package com.example.demo.controller;

import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.NhanVien;
import com.example.demo.service.ChiTietSPService;
import com.example.demo.service.HoaDonChiTietService;
import com.example.demo.service.HoaDonService;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.impl.HoaDonChiTietServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.jpa.repository.Modifying;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/hoa-don-chi-tiet")
public class HoaDonChiTietContronler {
    @Autowired
    private HoaDonChiTietService service;
    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private HoaDonService hoaDonService;

    @GetMapping("/hien-thi")
    public String hienThi(
            Model model,
//            @ModelAttribute("chucVu") ChucVu chucVu,
            @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {

        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<HoaDonChiTiet> page = service.getAll(pageable);
        model.addAttribute("tbt", service.getAll1());
        model.addAttribute("dulieu", page.getContent()); //danh sách list trong trang
        model.addAttribute("total", page.getTotalPages()); // tổng số trang(trang đếm từ 0)
        return "trang-home-HoaDonChiTiet";
    }


    @GetMapping("/view-update/{idhd}/{idctsp}")

    public String viewUpdate(Model model,
                             @ModelAttribute("dulieuxem") HoaDonChiTiet hoaDonChiTiet,
                             @PathVariable("idhd") UUID idhd,
                             @PathVariable("idctsp") UUID idctsp

    ) {

        hoaDonChiTiet = service.getOne(idhd, idctsp);

        System.out.println("tacocooc" + service.getOne(idhd, idctsp));

        model.addAttribute("dulieuxem", hoaDonChiTiet);
        model.addAttribute("chitietsanpham", chiTietSPService.getAll1());
        model.addAttribute("hoadon", hoaDonService.getAll1());
        model.addAttribute("tbt", service.getAll1());
        return "trang-update-HoaDonChiTiet";
    }

    @PostMapping("/update/{idhd}/{idctsp}")
    public String updateChucVu(
            @PathVariable("idhd") UUID idhd,
            @PathVariable("idctsp") UUID idctsp,
            @ModelAttribute("dulieuxem") HoaDonChiTiet hoaDonChiTiet  // dùng form string
    ) {
        HoaDonChiTiet hdct = service.getOne(idhd, idctsp);
        hdct.setDonGia(hoaDonChiTiet.getDonGia());
        hdct.setSoluong(hoaDonChiTiet.getSoluong());
        service.ADDvsUPDATE(hdct);

        return "redirect:/hoa-don-chi-tiet/hien-thi";


    }


    @GetMapping("/view-add")

    public String viewadd(Model model,
                          @ModelAttribute("dulieuxem") HoaDonChiTiet hoaDonChiTiet


    ) {


        model.addAttribute("dulieuxem", hoaDonChiTiet);
        model.addAttribute("chitietsanpham", chiTietSPService.getAll1());
        model.addAttribute("hoadon", hoaDonService.getAll1());
        model.addAttribute("tbt", service.getAll1());
        return "trang-add-HoaDonChiTiet";
    }

    @PostMapping("/add")
    public String add(
            @ModelAttribute("dulieuxem") HoaDonChiTiet hoaDonChiTiet  // dùng form spring
    ) {

        service.ADDvsUPDATE(hoaDonChiTiet);
        return "redirect:/hoa-don-chi-tiet/hien-thi";
    }

    @GetMapping("/remove/{idhd}/{idctsp}")
    public String remove(
            @PathVariable("idhd") UUID idhd,
            @PathVariable("idctsp") UUID idctsp
    ) {
        System.out.println("vvvvvvvv--" + idhd + "---" + idctsp);
        service.delete(idhd, idctsp);


        return "redirect:/hoa-don-chi-tiet/hien-thi";
    }

//    @Scheduled(fixedRate = 1000)
//    public void  inlinhtinh(){
//        System.out.println("chay vãi ò");
//    }
}

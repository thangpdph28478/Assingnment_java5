package com.example.demo.controller;

import com.example.demo.model.MauSac;
import com.example.demo.service.MauSacService;
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

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/mau-sac")
public class MauSacContronler {

    @Autowired
    private MauSacService service;
    @Autowired
    private MauSacService cuaHangService;
    @Autowired
    private MauSacService chucVuService;

    @GetMapping("/hien-thi")
    public String hienThi(
            Model model,
//            @ModelAttribute("chucVu") MauSac chucVu,
            @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {

        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<MauSac> page = service.getAll(pageable);
        model.addAttribute("tbt", service.getAll1());
        model.addAttribute("dulieu", page.getContent()); //danh sách list trong trang
        model.addAttribute("total", page.getTotalPages()); // tổng số trang(trang đếm từ 0)
        return "trang-home-MauSac";
    }


    @GetMapping("/remove/{id}")

    public String remove(Model model,
                         @PathVariable("id") UUID id

    ) {
        service.delete(id);
        return "redirect:/mau-sac/hien-thi";
    }


    @GetMapping("/view-update/{id}")

    public String viewUpdate(Model model,
                             @PathVariable("id") UUID id

    ) {
        System.out.println(id);
        MauSac sp = service.getOne(id);
        model.addAttribute("dulieuxem", sp);
        model.addAttribute("chucvu", chucVuService.getAll1());
        model.addAttribute("cuahang", cuaHangService.getAll1());
        model.addAttribute("tbt", service.getAll1());
        return "trang-update-MauSac";
    }


    @PostMapping("/update/{id}")
    public String updateMauSac(Model model,
                               @PathVariable("id") UUID id,
                               @ModelAttribute("dulieuxem") MauSac nhanVien  // dùng form string
    ) {
        MauSac sp = service.getOne(id);

        BeanUtils.copyProperties(nhanVien, sp);
        // vt1: bên form
        // vt2:của get one


        service.ADDvsUPDATE(sp);
        return "redirect:/mau-sac/hien-thi";
    }


    @GetMapping("/view-add")

    public String viewadd(Model model,
                          @ModelAttribute("dulieuxem") MauSac nhanVien //vif dungf from string dulieuthem been add neu ko co dong ny se loi


    ) {
        // dong 107,108,109 dùng check radio chọn 1 trong 2, chứ sping form radio ko dc dung checked.đậu xanh
//        nhanVien.setGioiTinh("Nam");

        model.addAttribute("dulieuxem", nhanVien);
        //
        model.addAttribute("tbt", service.getAll1());
        model.addAttribute("chucvu", chucVuService.getAll1());
        model.addAttribute("cuahang", cuaHangService.getAll1());

        return "trang-add-MauSac";
    }


    @PostMapping("/add")
    public String updateadd(Model model,
                            @ModelAttribute("dulieuxem") MauSac nhanVien  // dùng form string
    ) {


        service.ADDvsUPDATE(nhanVien);
        return "redirect:/mau-sac/hien-thi";
    }


}

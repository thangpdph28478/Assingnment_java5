package com.example.demo.controller;

import com.example.demo.model.ChiTietSP;
import com.example.demo.model.ChucVu;
import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.HoaDon;

import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.IdChiTietHoaDon;
import com.example.demo.service.ChiTietSPService;
import com.example.demo.service.HoaDonChiTietService;
import com.example.demo.service.HoaDonService;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.NhanVienService;
import com.example.demo.viewmodel.Thongtinhoadon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/ban-hang-tai-quay")
public class BanHangTaiQuayConTroller {
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private NhanVienService nhanVienService;


    List<Thongtinhoadon> dl(Pageable pageable) {
        List<Thongtinhoadon> tthd = new ArrayList<>();
        for (HoaDon hd : hoaDonService.getAll(pageable)) {
            tthd.add(new Thongtinhoadon(hd.getId(), hd.getMa(), hoaDonChiTietService.tongsanpham(hd.getId()), hoaDonChiTietService.tongtien(hd.getId()), hd.getNgayTao(), hd.tt()));
        }
        return tthd;
    }

    @GetMapping("/hien-thi")
    public String hienThi(
            Model model,
//            @ModelAttribute("chucVu") ChucVu chucVu,
            @RequestParam("pageNum") Optional<Integer> pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize
    ) {
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
//        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<Thongtinhoadon> page = new PageImpl<>(dl(pageable), pageable, hoaDonService.getAll1().size());

        model.addAttribute("dulieu", page.getContent());
        model.addAttribute("page", page.getNumber());// vị trí trang dc trọn
        model.addAttribute("total", page.getTotalPages()); // tổng số trang(trang đếm từ 0)
        return "BanHangTaiQuay";
    }

    @GetMapping("/tao-hoa-don")
    public String taohoadon(
            Model model
//       @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
//@RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {

        String mhd = "MHD" + hoaDonService.getAll1().size();
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        hoaDonService.ADDvsUPDATE(new HoaDon(mhd, date, 0));
        HoaDon hoaDon = hoaDonService.timmhd(mhd);
        List<HoaDonChiTiet> listhdct = hoaDonChiTietService.detailall(hoaDon.getId());

        model.addAttribute("mhd", hoaDon);
        model.addAttribute("idhd", hoaDon.getId());
        model.addAttribute("dulieuhdct", listhdct);

        model.addAttribute("khachhang", khachHangService.getAll1());
        model.addAttribute("nhanvien", nhanVienService.getAll1());
        model.addAttribute("dulieuctsp", chiTietSPService.getAll1());
        model.addAttribute("tongtien", hoaDonChiTietService.tongtien(hoaDon.getId()));
        return "TaoHoaDon";
    }


    @PostMapping("/detail-hoadon")
    public String xemhoadon(
            Model model, @RequestParam("id") UUID id
//       @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
//@RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {

//        chonkhach
        HoaDon hoaDon = hoaDonService.getOne(id);
        List<HoaDonChiTiet> listhdct = hoaDonChiTietService.detailall(hoaDon.getId());
if(hoaDon.getIdKhachHang() != null){
    model.addAttribute("chonkhach","ko");
}else {
    model.addAttribute("chonkhach","ko");
}
        model.addAttribute("mhd", hoaDon);
        model.addAttribute("dulieuhdct", listhdct);
        model.addAttribute("idhd", id);
        model.addAttribute("dulieuctsp", chiTietSPService.getAll1());
        model.addAttribute("khachhang", khachHangService.getAll1());
        model.addAttribute("nhanvien", nhanVienService.getAll1());
        model.addAttribute("tongtien", hoaDonChiTietService.tongtien(hoaDon.getId()));
        return "TaoHoaDon";
    }


    @PostMapping("/removectsp")
    public String remove(Model model,
                         @RequestParam("idhd") UUID idhd,
                         @RequestParam("idctsp") UUID idctsp

    ) {

        HoaDonChiTiet hdct = hoaDonChiTietService.getOne(idhd, idctsp);
        Integer slbandau = hdct.getSoluong();


        hoaDonChiTietService.delete(idhd, idctsp);


        Integer slchuyenvao = chiTietSPService.getOne(idctsp).getSoLuongTon() + slbandau;
        chiTietSPService.getOne(idctsp).setSoLuongTon(slchuyenvao);
        chiTietSPService.ADDvsUPDATE(chiTietSPService.getOne(idctsp));

        HoaDon hoaDon = hoaDonService.getOne(idhd);
        if(hoaDon.getIdKhachHang() != null){
            model.addAttribute("chonkhach","ko");
        }else {
            model.addAttribute("chonkhach","ko");
        }
        List<HoaDonChiTiet> listhdct = hoaDonChiTietService.detailall(hoaDon.getId());
        String mhd = hoaDon.getMa();
        model.addAttribute("mhd", hoaDon);
        model.addAttribute("dulieuhdct", listhdct);
        model.addAttribute("idhd", idhd);
        model.addAttribute("dulieuctsp", chiTietSPService.getAll1());
        model.addAttribute("khachhang", khachHangService.getAll1());
        model.addAttribute("nhanvien", nhanVienService.getAll1());
        model.addAttribute("tongtien", hoaDonChiTietService.tongtien(hoaDon.getId()));
        return "TaoHoaDon";
    }


    @PostMapping("/updatectsp")
    public String update(Model model,
                         @RequestParam("idhd") UUID idhd,
                         @RequestParam("idctsp") UUID idctsp,
                         @RequestParam("sdcd") Integer slcud

    ) {


        HoaDonChiTiet hdct = hoaDonChiTietService.getOne(idhd, idctsp);
        Integer slbandau = hdct.getSoluong();

        hdct.setSoluong(slcud);

//  chiTietSPService.getOne(idctsp)
        hoaDonChiTietService.ADDvsUPDATE(hdct);

        if (slcud > slbandau) {
            Integer slchuyenvao = chiTietSPService.getOne(idctsp).getSoLuongTon() - (slcud - slbandau);
            chiTietSPService.getOne(idctsp).setSoLuongTon(slchuyenvao);
            chiTietSPService.ADDvsUPDATE(chiTietSPService.getOne(idctsp));
        } else {
            Integer slchuyenvao = chiTietSPService.getOne(idctsp).getSoLuongTon() + (slbandau - slcud);
            chiTietSPService.getOne(idctsp).setSoLuongTon(slchuyenvao);
            chiTietSPService.ADDvsUPDATE(chiTietSPService.getOne(idctsp));
        }


        HoaDon hoaDon = hoaDonService.getOne(idhd);
        if(hoaDon.getIdKhachHang() != null){
            model.addAttribute("chonkhach","ko");
        }else {
            model.addAttribute("chonkhach","ko");
        }
        List<HoaDonChiTiet> listhdct = hoaDonChiTietService.detailall(hoaDon.getId());
        String mhd = hoaDon.getMa();
        model.addAttribute("mhd", hoaDon);
        model.addAttribute("dulieuhdct", listhdct);
        model.addAttribute("idhd", idhd);
        model.addAttribute("dulieuctsp", chiTietSPService.getAll1());
        model.addAttribute("khachhang", khachHangService.getAll1());
        model.addAttribute("nhanvien", nhanVienService.getAll1());
        model.addAttribute("tongtien", hoaDonChiTietService.tongtien(hoaDon.getId()));
        return "TaoHoaDon";
    }


    @PostMapping("/themspgh")
    public String add(
            Model model,
            @RequestParam("idhd") UUID idhd,
            @RequestParam("idctsp") UUID idctsp,
            @RequestParam("slmua") Integer slmua,
            @RequestParam("dongia") BigDecimal dongia
//            @ModelAttribute("vo") HoaDonChiTiet hoaDonChiTiet
    ) {


        if (hoaDonChiTietService.getOne(idhd, idctsp) == null) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            HoaDon hoaDon = hoaDonService.getOne(idhd);
            ChiTietSP chiTietSP = chiTietSPService.getOne(idctsp);
            IdChiTietHoaDon idChiTietHoaDon = new IdChiTietHoaDon();
            idChiTietHoaDon.setIdHoadon(hoaDon);
            idChiTietHoaDon.setIdChiTietSP(chiTietSP);
            hoaDonChiTiet.setId(idChiTietHoaDon);
            hoaDonChiTiet.setSoluong(slmua);
            hoaDonChiTiet.setDonGia(dongia);
            hoaDonChiTietService.ADDvsUPDATE(hoaDonChiTiet);


            ChiTietSP ctsp = chiTietSPService.getOne(idctsp);
            Integer sludctsp = ctsp.getSoLuongTon() - slmua;
            chiTietSP.setSoLuongTon(sludctsp);
            chiTietSPService.ADDvsUPDATE(chiTietSP);

        } else {

            HoaDonChiTiet hdct = hoaDonChiTietService.getOne(idhd, idctsp);
            Integer slud = hdct.getSoluong() + slmua;
            hdct.setSoluong(slud);
            hoaDonChiTietService.ADDvsUPDATE(hdct);
            ChiTietSP chiTietSP = chiTietSPService.getOne(idctsp);
            Integer sludctsp = chiTietSP.getSoLuongTon() - slmua;
            chiTietSP.setSoLuongTon(sludctsp);
            chiTietSPService.ADDvsUPDATE(chiTietSP);
        }


        HoaDon hoaDon = hoaDonService.getOne(idhd);
        if(hoaDon.getIdKhachHang() != null){
            model.addAttribute("chonkhach","ko");
        }else {
            model.addAttribute("chonkhach","ko");
        }
        List<HoaDonChiTiet> listhdct = hoaDonChiTietService.detailall(hoaDon.getId());
        String mhd = hoaDon.getMa();
        model.addAttribute("mhd", hoaDon);
        model.addAttribute("dulieuhdct", listhdct);
        model.addAttribute("idhd", idhd);
        model.addAttribute("dulieuctsp", chiTietSPService.getAll1());
        model.addAttribute("khachhang", khachHangService.getAll1());
        model.addAttribute("nhanvien", nhanVienService.getAll1());

        model.addAttribute("tongtien", hoaDonChiTietService.tongtien(hoaDon.getId()));
        return "TaoHoaDon";
    }


    @PostMapping("/thanh-toan")
    public String thanhtoan(Model model,
                            @RequestParam("idhdtt") UUID idhd,
                            @RequestParam("chonkhach") String chonkhach,
                            @RequestParam("dsnhanvien") UUID idnv,
                            @RequestParam("dskhachhang") UUID idkh

    ) {
 HoaDon hoaDon=hoaDonService.getOne(idhd);
        hoaDon.setTinhTrang(1);
        hoaDon.setIdNhanVien(nhanVienService.getOne(idnv));
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        hoaDon.setNgayThanhToan(date);
 if(chonkhach.equals("co")){

     hoaDon.setIdKhachHang(khachHangService.getOne(idkh));


     hoaDonService.ADDvsUPDATE(hoaDon);
 }else {
     hoaDonService.ADDvsUPDATE(hoaDon);
 }

        return "redirect:/ban-hang-tai-quay/hien-thi";
    }
}

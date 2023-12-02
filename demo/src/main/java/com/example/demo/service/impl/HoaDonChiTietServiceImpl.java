package com.example.demo.service.impl;

import com.example.demo.model.ChucVu;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public List<HoaDonChiTiet> getAll1() {
        return (List<HoaDonChiTiet>) hoaDonChiTietRepository.findAll();
    }

    //lấy tất
    @Override
    public Page<HoaDonChiTiet> getAll(Pageable pageable) {
        return hoaDonChiTietRepository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public HoaDonChiTiet getOne(UUID idhd, UUID idctsp) {

        return hoaDonChiTietRepository.detail(idhd, idctsp);
    }

    @Override
    public HoaDonChiTiet getOne1(Integer sl) {
        return hoaDonChiTietRepository.detail1(sl);
    }


    @Override

    public void ADDvsUPDATE(HoaDonChiTiet gioHangChiTiet) {
        hoaDonChiTietRepository.save(gioHangChiTiet);
        // save đối tượng không id:thêm
        // save đối tượng có id:sửa
    }

    @Override
    public void themsql(UUID id1, UUID id2, Integer sl, BigDecimal dg) {
//        hoaDonChiTietRepository.them(id1,id2,sl,dg);
    }


    //xoa
    @Override
    public void delete(UUID id, UUID id1) {

        hoaDonChiTietRepository.xoa(id, id1);
    }


    //tim
    @Override
    public List<HoaDonChiTiet> search(String ten) {
//        return hoaDonChiTietRepository.search(ten);
        return null;
    }

    @Override
    public List<HoaDonChiTiet> detailall(UUID id) {
        System.out.println("ooooooooooo" + id);
        return hoaDonChiTietRepository.detailall(id);


    }

    @Override
    public Integer tongsanpham(UUID id) {
        Integer Tongsp = 0;


        for (HoaDonChiTiet hdct : hoaDonChiTietRepository.detailall(id)) {


            Tongsp = hdct.getSoluong() + Tongsp;


        }

        return Tongsp;
    }

    @Override
    public Integer tongtien(UUID id) {
        Integer Tongtien = 0;


        for (HoaDonChiTiet hdct : hoaDonChiTietRepository.detailall(id)) {


            Tongtien = Tongtien + hdct.getSoluong() * hdct.cv();


        }
        return Tongtien;
    }

}

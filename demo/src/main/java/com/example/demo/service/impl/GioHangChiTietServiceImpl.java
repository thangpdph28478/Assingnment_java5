package com.example.demo.service.impl;

import com.example.demo.model.GioHangChiTiet;
import com.example.demo.repository.GioHangChiTietRepository;
import com.example.demo.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    @Autowired
    GioHangChiTietRepository gioHangChiTietRepository;

    @Override
    public List<GioHangChiTiet> getAll1() {
        return (List<GioHangChiTiet>) gioHangChiTietRepository.findAll();
    }

    //lấy tất
    @Override
    public Page<GioHangChiTiet> getAll(Pageable pageable) {
        return gioHangChiTietRepository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public GioHangChiTiet getOne(UUID idhd, UUID idctsp) {

        return gioHangChiTietRepository.detail(idhd, idctsp);
    }

    @Override
    public GioHangChiTiet getOne1(Integer sl) {
        return gioHangChiTietRepository.detail1(sl);
    }


    @Override

    public void ADDvsUPDATE(GioHangChiTiet gioHangChiTiet) {
        gioHangChiTietRepository.save(gioHangChiTiet);
        // save đối tượng không id:thêm
        // save đối tượng có id:sửa
    }


    //xoa
    @Override
    public void delete(UUID id, UUID id1) {

        gioHangChiTietRepository.xoa(id, id1);
    }

    @Override
    public void delete1(UUID id) {
        gioHangChiTietRepository.xoaful(id);
    }


    //tim
    @Override
    public List<GioHangChiTiet> search(String ten) {
//        return gioHangChiTietRepository.search(ten);
        return null;
    }

    @Override
    public List<GioHangChiTiet> timgiohang(UUID ten) {
        return gioHangChiTietRepository.timgiohang(ten);
    }

}

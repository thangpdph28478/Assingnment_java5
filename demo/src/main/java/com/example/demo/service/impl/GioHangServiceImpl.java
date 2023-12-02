package com.example.demo.service.impl;

import com.example.demo.model.GioHang;
import com.example.demo.repository.GioHangRepository;
import com.example.demo.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    GioHangRepository repository;

    @Override
    public List<GioHang> getAll1() {
        return (List<GioHang>) repository.findAll();
    }

    //lấy tất
    @Override
    public Page<GioHang> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public GioHang getOne(UUID id) {
        return repository.findById(id).orElse(null);
    }


    @Override

    public void ADDvsUPDATE(GioHang chucVu) {
        repository.save(chucVu);
        // save đối tượng không id:thêm
        // save đối tượng có id:sửa
    }


    //xoa
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }


    //tim
    @Override
    public List<GioHang> search(String ten) {
//        return repository.search(ten);
        return null;
    }


}

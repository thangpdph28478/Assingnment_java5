package com.example.demo.service.impl;

import com.example.demo.model.CuaHang;
import com.example.demo.repository.CuaHangRepository;
import com.example.demo.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    CuaHangRepository repository;

    @Override
    public List<CuaHang> getAll1() {
        return (List<CuaHang>) repository.findAll();
    }

    //lấy tất
    @Override
    public Page<CuaHang> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public CuaHang getOne(UUID id) {
        return repository.findById(id).orElse(null);
    }


    @Override

    public void ADDvsUPDATE(CuaHang chucVu) {
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
    public List<CuaHang> search(String ten) {
//        return repository.search(ten);
        return null;
    }
}

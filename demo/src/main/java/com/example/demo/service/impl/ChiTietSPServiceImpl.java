package com.example.demo.service.impl;

import com.example.demo.model.ChiTietSP;
import com.example.demo.repository.ChiTietSPRepository;
import com.example.demo.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {
    @Autowired
    ChiTietSPRepository repository;

    @Override
    public List<ChiTietSP> getAll1() {
        return repository.findAll();
    }

    //lấy tất
    @Override
    public Page<ChiTietSP> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public ChiTietSP getOne(UUID id) {
        return repository.findById(id).orElse(null);
    }


    @Override

    public void ADDvsUPDATE(ChiTietSP chucVu) {
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
    public List<ChiTietSP> search(String ten) {
//        return repository.search(ten);
        return null;

    }


}

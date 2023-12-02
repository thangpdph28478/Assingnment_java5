package com.example.demo.service.impl;

import com.example.demo.model.NSX;
import com.example.demo.model.NSX;

import com.example.demo.repository.NSXRepository;
import com.example.demo.repository.NSXRepository;
import com.example.demo.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class NSXServiceImpl implements NSXService {
    @Autowired
    NSXRepository repository;

    @Override
    public List<NSX> getAll1() {
        return repository.findAll();
    }

    //lấy tất
    @Override
    public Page<NSX> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public NSX getOne(UUID id) {
        return repository.findById(id).orElse(null);
    }


    @Override

    public void ADDvsUPDATE(NSX chucVu) {
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
    public List<NSX> search(String ten) {
//        return repository.search(ten);
        return null;

    }

}

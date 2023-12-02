package com.example.demo.service.impl;

import com.example.demo.model.MauSac;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacRepository repository;

    @Override
    public List<MauSac> getAll1() {
        return repository.findAll();
    }

    //lấy tất
    @Override
    public Page<MauSac> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public MauSac getOne(UUID id) {
        return repository.findById(id).orElse(null);
    }


    @Override

    public void ADDvsUPDATE(MauSac chucVu) {
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
    public List<MauSac> search(String ten) {
//        return repository.search(ten);
        return null;

    }

}

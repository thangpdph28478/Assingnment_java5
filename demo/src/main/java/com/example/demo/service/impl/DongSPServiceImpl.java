package com.example.demo.service.impl;

import com.example.demo.model.DongSP;
import com.example.demo.repository.DongSPRepository;
import com.example.demo.service.DongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSPServiceImpl implements DongSPService {
    @Autowired
    DongSPRepository repository;

    @Override
    public List<DongSP> getAll1() {
        return repository.findAll();
    }

    //lấy tất
    @Override
    public Page<DongSP> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public DongSP getOne(UUID id) {
        return repository.findById(id).orElse(null);
    }


    @Override

    public void ADDvsUPDATE(DongSP chucVu) {
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
    public List<DongSP> search(String ten) {
//        return repository.search(ten);
        return null;

    }
}

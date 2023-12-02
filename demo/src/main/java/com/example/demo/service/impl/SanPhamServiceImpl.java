package com.example.demo.service.impl;

import com.example.demo.model.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository repository;

    @Override
    public List<SanPham> getAll1() {
        return repository.findAll();
    }

    //lấy tất
    @Override
    public Page<SanPham> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public SanPham getOne(UUID id) {
        return repository.findById(id).orElse(null);
    }


    @Override

    public void ADDvsUPDATE(SanPham chucVu) {
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
    public List<SanPham> search(String ten) {
//        return repository.search(ten);
        return null;

    }

}

package com.example.demo.service.impl;

import com.example.demo.model.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    NhanVienRepository repository;

    @Override
    public List<NhanVien> getAll1() {
        return (List<NhanVien>) repository.findAll();
    }

    //lấy tất
    @Override
    public Page<NhanVien> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public NhanVien getOne(UUID id) {
        return repository.findById(id).orElse(null);
    }


    @Override

    public void ADDvsUPDATE(NhanVien chucVu) {
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
    public List<NhanVien> search(String ten) {
        return repository.search(ten);

    }

}

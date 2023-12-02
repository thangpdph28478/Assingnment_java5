package com.example.demo.service.impl;

import com.example.demo.model.ChiTietSP;
import com.example.demo.model.KhachHang;
import com.example.demo.model.KhachHang;
import com.example.demo.repository.ChiTietSPRepository;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepository repository;

    @Override
    public List<KhachHang> getAll1() {
        return (List<KhachHang>) repository.findAll();
    }

    //lấy tất
    @Override
    public Page<KhachHang> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public KhachHang getOne(UUID id) {
        return repository.findById(id).orElse(null);
    }


    @Override

    public void ADDvsUPDATE(KhachHang chucVu) {
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
    public List<KhachHang> search(String ten) {
//        return repository.search(ten);
return null;
    }

}

package com.example.demo.service.impl;

import com.example.demo.model.ChiTietSP;
import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDon;
import com.example.demo.repository.ChiTietSPRepository;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepository repository;

    @Override
    public List<HoaDon> getAll1() {
        return (List<HoaDon>) repository.findAll();
    }

    //lấy tất
    @Override
    public Page<HoaDon> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //khai báo để phân trang
    @Override
    public HoaDon getOne(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public HoaDon timmhd(String mhd) {
        return repository.timmhd(mhd);
    }


    @Override

    public void ADDvsUPDATE(HoaDon chucVu) {
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
    public List<HoaDon> search(String ten) {
//        return repository.search(ten);
        return null;
    }

}

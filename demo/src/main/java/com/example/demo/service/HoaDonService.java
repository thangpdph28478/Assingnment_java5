package com.example.demo.service;

import com.example.demo.model.HoaDon;
import com.example.demo.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    public List<HoaDon> getAll1();

    public Page<HoaDon> getAll(Pageable pageable);

    public HoaDon getOne(UUID id);

    public HoaDon timmhd(String mhd);

    public void ADDvsUPDATE(HoaDon nhanVien);

    public void delete(UUID id);

    public List<HoaDon> search(String ten);
}

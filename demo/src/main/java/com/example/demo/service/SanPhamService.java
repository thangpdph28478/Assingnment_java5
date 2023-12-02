package com.example.demo.service;

import com.example.demo.model.NhanVien;
import com.example.demo.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    public List<SanPham> getAll1();

    public Page<SanPham> getAll(Pageable pageable);

    public SanPham getOne(UUID id);

    public void ADDvsUPDATE(SanPham nhanVien);

    public void delete(UUID id);

    public List<SanPham> search(String ten);
}

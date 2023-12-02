package com.example.demo.service;

import com.example.demo.model.KhachHang;
import com.example.demo.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    public List<KhachHang> getAll1();

    public Page<KhachHang> getAll(Pageable pageable);

    public KhachHang getOne(UUID id);

    public void ADDvsUPDATE(KhachHang nhanVien);

    public void delete(UUID id);

    public List<KhachHang> search(String ten);
}

package com.example.demo.service;

import com.example.demo.model.CuaHang;
import com.example.demo.model.KhachHang;
import com.example.demo.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    public List<CuaHang> getAll1();

    public Page<CuaHang> getAll(Pageable pageable);

    public CuaHang getOne(UUID id);

    public void ADDvsUPDATE(CuaHang nhanVien);

    public void delete(UUID id);

    public java.util.List<CuaHang> search(String ten);
}

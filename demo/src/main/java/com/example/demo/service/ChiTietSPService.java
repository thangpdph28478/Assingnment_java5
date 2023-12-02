package com.example.demo.service;

import com.example.demo.model.ChiTietSP;
import com.example.demo.model.ChiTietSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    public List<ChiTietSP> getAll1();

    public Page<ChiTietSP> getAll(Pageable pageable);

    public ChiTietSP getOne(UUID id);

    public void ADDvsUPDATE(ChiTietSP nhanVien);

    public void delete(UUID id);

    public List<ChiTietSP> search(String ten);
}

package com.example.demo.service;

import com.example.demo.model.DongSP;
import com.example.demo.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface DongSPService {
    public List<DongSP> getAll1();

    public Page<DongSP> getAll(Pageable pageable);

    public DongSP getOne(UUID id);

    public void ADDvsUPDATE(DongSP nhanVien);

    public void delete(UUID id);

    public List<DongSP> search(String ten);
}

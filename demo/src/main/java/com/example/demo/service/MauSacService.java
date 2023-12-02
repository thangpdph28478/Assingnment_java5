package com.example.demo.service;

import com.example.demo.model.MauSac;
import com.example.demo.model.NhanVien;
import com.example.demo.model.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface MauSacService {
    public List<MauSac> getAll1();

    public Page<MauSac> getAll(Pageable pageable);

    public MauSac getOne(UUID id);

    public void ADDvsUPDATE(MauSac nhanVien);

    public void delete(UUID id);

    public List<MauSac> search(String ten);
}

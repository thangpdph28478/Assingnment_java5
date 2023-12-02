package com.example.demo.service;

import com.example.demo.model.NSX;
import com.example.demo.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface NSXService {
    public List<NSX> getAll1();

    public Page<NSX> getAll(Pageable pageable);

    public NSX getOne(UUID id);

    public void ADDvsUPDATE(NSX nhanVien);

    public void delete(UUID id);

    public List<NSX> search(String ten);
}

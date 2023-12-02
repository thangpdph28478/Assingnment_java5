package com.example.demo.repository;

import com.example.demo.model.ChucVu;
import com.example.demo.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

// tìm kiếm: thắng có cách khác, nhưng làm kiểu này là nhanh và hay nhất

    @Query("select sp from NhanVien  sp where sp.ten like %?1%")
    List<NhanVien> search(String ten);


}

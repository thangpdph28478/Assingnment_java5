package com.example.demo.repository;

import com.example.demo.model.NSX;
import com.example.demo.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NSXRepository extends JpaRepository<NSX, UUID> {
}

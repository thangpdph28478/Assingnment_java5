package com.example.demo.repository;

import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.NhanVien;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, UUID> {

    @Query("select  sp from GioHangChiTiet sp where sp.id.idGioHang.id=?1 and sp.id.idChiTietSP.id=?2")
    GioHangChiTiet detail(UUID id, UUID id1);

    @Transactional
    @Modifying
    @Query("DELETE FROM GioHangChiTiet sp WHERE sp.id.idGioHang.id = ?1 AND sp.id.idChiTietSP.id = ?2")
    void xoa(UUID id1, UUID id2);


    @Transactional
    @Modifying
    @Query("DELETE FROM GioHangChiTiet sp WHERE sp.id.idGioHang.id = ?1 ")
    void xoaful(UUID id1);

    @Query("select  sp from GioHangChiTiet sp where sp.soluong=?1")
    GioHangChiTiet detail1(Integer sl);

    @Query("select  sp from GioHangChiTiet sp where sp.id.idGioHang.id=?1 ")
    List<GioHangChiTiet> timgiohang(UUID id);
}

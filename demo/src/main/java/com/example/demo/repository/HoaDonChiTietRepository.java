package com.example.demo.repository;

import com.example.demo.model.HoaDonChiTiet;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, UUID> {


    @Query("select  sp from HoaDonChiTiet sp where sp.id.idHoadon.id=?1 and sp.id.idChiTietSP.id=?2")
    HoaDonChiTiet detail(UUID id, UUID id1);

    @Transactional
    @Modifying
    @Query("DELETE FROM HoaDonChiTiet sp WHERE sp.id.idHoadon.id = ?1 AND sp.id.idChiTietSP.id = ?2")
    void xoa(UUID id1, UUID id2);


//    @Transactional
//    @Modifying
//    @Query("INSERT INTO HoaDonChiTiet  (id_hoa_don,id_chi_tiet_sp, so_luong, don_gia) VALUES (?1,?2,?3,?4)")
//    void them(UUID id1, UUID id2, Integer sl, BigDecimal dongia);

    @Query("select  sp from HoaDonChiTiet sp where sp.soluong=?1")
    HoaDonChiTiet detail1(Integer sl);

    @Query("select  sp from HoaDonChiTiet sp where sp.id.idHoadon.id=?1 ")
    List<HoaDonChiTiet> detailall(UUID id);
}

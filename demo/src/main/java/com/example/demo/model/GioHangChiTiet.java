package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "gio_hang_chi_tiet")
public class GioHangChiTiet {

    @EmbeddedId
    private IdChiTietGioHang id;
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Type(type = "uuid-char")
//    private UUID id;
//
//    @ManyToOne
//    @JoinColumn(name = "id_gio_hang")
//    private GioHang idGioHang;
//
//    @ManyToOne
//    @JoinColumn(name = "id_chi_tiet_sp")
//    private ChiTietSP idChiTietSP;

    @Column(name = "so_luong")
    private Integer soluong;

    @Column(name = "don_gia")
    private BigDecimal donGia;

    @Column(name = "don_gia_khi_giam")
    private BigDecimal donGiaKhiGiam;

    public BigDecimal getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(BigDecimal donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }
}

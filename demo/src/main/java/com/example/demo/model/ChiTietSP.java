package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "chi_tiet_sp")
public class ChiTietSP {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Type(type = "uuid-char")
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_sp", referencedColumnName = "id")
    private SanPham idSp;

    @ManyToOne
    @JoinColumn(name = "id_nsx", referencedColumnName = "id")
    private NSX idNsx;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac", referencedColumnName = "id")
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "id_dong_sp", referencedColumnName = "id")
    private DongSP idDongSp;

    @Column(name = "nam_bh")
    private Integer namBaoHang;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @Column(name = "gia_nhap")
    private BigDecimal giaNhap;

    @Column(name = "Gia_ban")
    private BigDecimal giaBan;

    public ChiTietSP(SanPham idSp) {
        this.idSp = idSp;
    }

    public ChiTietSP(SanPham idSp, NSX idNsx, MauSac idMauSac, DongSP idDongSp, Integer namBaoHang, String moTa, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.idSp = idSp;
        this.idNsx = idNsx;
        this.idMauSac = idMauSac;
        this.idDongSp = idDongSp;
        this.namBaoHang = namBaoHang;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getCTSP() {

        return idSp.getMa() +
                "-" + idSp.getTen() +
                "-" + idNsx.getTen() +
                "-" + idDongSp.getTen() +
                "-" + idMauSac.getTen();
    }


}

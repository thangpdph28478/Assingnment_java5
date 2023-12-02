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

import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
//    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "ten_dem")
    private String tenDem;

    @Column(name = "ho")
    private String ho;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "mat_khau")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "id_ch", referencedColumnName = "id")
    private CuaHang idCh;

    @ManyToOne
    @JoinColumn(name = "id_cv", referencedColumnName = "id")
    private ChucVu idCv;

    @Column(name = "trang_thai")
    private Integer trangThai;

    public NhanVien(String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, CuaHang idCh, ChucVu idCv, Integer trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCh = idCh;
        this.idCv = idCv;
        this.trangThai = trangThai;
    }

    public String getTTNV() {
        return ma + "-" + ho + " " + tenDem + " " + ten;
    }

    public String ctt() {
        if (this.getTrangThai() == 0) {
            return "NGHỈ LÀM";
        }
        return "ĐI LÀM";
    }
}

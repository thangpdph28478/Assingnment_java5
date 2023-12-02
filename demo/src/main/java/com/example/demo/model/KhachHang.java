package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "khach_hang")
public class KhachHang {
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

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "thanh_pho")
    private String thanhPho;

    @Column(name = "quoc_gia")
    private String quocGia;

    @Column(name = "mat_khau")
    private String matKhau;

    public String getTTKH() {
        return ma + "-" + ho + " " + tenDem + " " + ten;
    }
}

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
@Table(name = "gio_hang")
public class GioHang {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
//    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_kh")
    private KhachHang idKhachHang;

    @ManyToOne
    @JoinColumn(name = "id_nv")
    private NhanVien idNhanVien;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToan;


    @Column(name = "ten_nguoi_nhan")
    private String tenNguoiNhan;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;

    public String tt() {
        if (tinhTrang == 0) {
            return "CHỜ THANH TOÁN";
        }
        return "ĐÃ THANH TOÁN";

    }
}

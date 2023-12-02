package com.example.demo.viewmodel;

import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.service.HoaDonChiTietService;
import com.example.demo.service.impl.HoaDonChiTietServiceImpl;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class Thongtinhoadon {

    private UUID id;
    private String ma;
    private Integer tongsanpham;
    private Integer tongtien;
    private Date ngayTao;
    private String tinhTrang;


}

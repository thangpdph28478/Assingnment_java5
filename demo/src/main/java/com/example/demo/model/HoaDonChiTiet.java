package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
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
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "hoa_don_chi_tiet")
public class HoaDonChiTiet {


    @EmbeddedId
    private IdChiTietHoaDon id;
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Type(type = "uuid-char")
//    private UUID id;

//    @ManyToOne
//    @JoinColumn(name = "id_hoa_don")
//    private HoaDon idHoadon;
//
//    @ManyToOne
//    @JoinColumn(name = "id_chi_tiet_sp")
//    private ChiTietSP idChiTietSP;

    @Column(name = "so_luong")
    private Integer soluong;

    @Column(name = "don_gia")
    private BigDecimal donGia;


    public Integer cv() {

        BigDecimal decimal = this.donGia;
        Integer integer = decimal.intValue();
        return integer;
    }
}

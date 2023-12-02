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
import org.hibernate.annotations.Type;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "cua_hang")
public class CuaHang {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
//    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;


    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "thanh_pho")
    private String thanhPho;

    @Column(name = "quoc_gia")
    private String quocGia;


    public String getGopMaTen() {

        return this.ma + "-" + this.ten;
    }
}

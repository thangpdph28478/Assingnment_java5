package com.example.demo.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Embeddable;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
public class IdChiTietHoaDon implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon idHoadon;

    @ManyToOne
    @JoinColumn(name = "id_chi_tiet_sp")
    private ChiTietSP idChiTietSP;


}

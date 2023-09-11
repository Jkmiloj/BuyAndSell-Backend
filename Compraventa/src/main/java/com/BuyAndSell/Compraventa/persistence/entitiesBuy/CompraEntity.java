package com.BuyAndSell.Compraventa.persistence.entitiesBuy;

import com.BuyAndSell.Compraventa.domain.PersonDto;
import com.BuyAndSell.Compraventa.domain.VehicleDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "COMPRA")
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBuy;
    private Date fechaCompra;
    private Integer cc;
    private String placa;

    public CompraEntity(Integer idBuy, Date fechaCompra, Integer cc, String placa) {
        this.idBuy = idBuy;
        this.fechaCompra = fechaCompra;
        this.cc = cc;
        this.placa = placa;
    }

    public Integer getIdBuy() {
        return idBuy;
    }

    public void setIdBuy(Integer idBuy) {
        this.idBuy = idBuy;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @ManyToOne
    @JoinColumn(name = "cc", referencedColumnName = "cc", insertable = false, updatable = false)
    private PersonDto personDto;

    @ManyToOne
    @JoinColumn(name = "placa", referencedColumnName = "placa", insertable = false, updatable = false)
    private VehicleDto vehicleDto;
}

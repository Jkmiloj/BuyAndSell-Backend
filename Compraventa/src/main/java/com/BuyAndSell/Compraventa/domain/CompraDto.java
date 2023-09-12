package com.BuyAndSell.Compraventa.domain;
import java.util.Date;

public class CompraDto {
    private Integer idBuy;
    private Date fechaCompra;
    private Integer cc;
    private String placa;
    private PersonDto personDto;
    private VehicleDto vehicleDto;

    public CompraDto(Integer idBuy, Date fechaCompra, Integer cc, String placa) {
        super();
        this.idBuy = idBuy;
        this.fechaCompra = fechaCompra;
        this.cc = cc;
        this.placa = placa;
        this.personDto = personDto;
        this.vehicleDto = vehicleDto;
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
}


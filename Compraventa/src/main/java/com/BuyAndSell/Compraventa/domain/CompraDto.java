package com.BuyAndSell.Compraventa.domain;
import lombok.Getter;
import java.util.Date;

@Getter
public class CompraDto {
    private Integer idBuy;
    private Date fechaCompra;
    private Integer cc;
    private String placa;
   /* private PersonDto personDto;
    private VehicleDto vehicleDto;*/

    public CompraDto(Integer idBuy, Date fechaCompra, Integer cc, String placa) {
        super();
        this.idBuy = idBuy;
        this.fechaCompra = fechaCompra;
        this.cc = cc;
        this.placa = placa;
        /*this.personDto = personDto;
        this.vehicleDto = vehicleDto;*/
    }

    public void setIdBuy(Integer idBuy) {
        this.idBuy = idBuy;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}


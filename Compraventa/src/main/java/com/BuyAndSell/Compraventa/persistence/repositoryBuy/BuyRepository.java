package com.BuyAndSell.Compraventa.persistence.repositoryBuy;

import com.BuyAndSell.Compraventa.domain.CompraDto;
import com.BuyAndSell.Compraventa.domain.PersonDto;
import com.BuyAndSell.Compraventa.domain.VehicleDto;

import java.util.List;

public interface BuyRepository {
    List<CompraDto> getAll();

    Integer save(CompraDto compraDto, PersonDto personDto, VehicleDto vehicleDto);
}

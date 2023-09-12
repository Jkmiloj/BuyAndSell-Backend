package com.BuyAndSell.Compraventa.persistence.repositoryBuy;

import com.BuyAndSell.Compraventa.domain.CompraDto;

import java.util.List;

public interface BuyRepository {

    List<CompraDto> getAll();

    Integer save(CompraDto compraDto);
}

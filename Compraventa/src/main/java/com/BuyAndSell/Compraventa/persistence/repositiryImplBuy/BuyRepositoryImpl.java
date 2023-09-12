package com.BuyAndSell.Compraventa.persistence.repositiryImplBuy;

import com.BuyAndSell.Compraventa.domain.CompraDto;
import com.BuyAndSell.Compraventa.domain.PersonDto;
import com.BuyAndSell.Compraventa.domain.VehicleDto;
import com.BuyAndSell.Compraventa.persistence.entitiesBuy.CompraEntity;
import com.BuyAndSell.Compraventa.persistence.repositoryBuy.BuyRepository;
import com.BuyAndSell.Compraventa.persistence.repositoryBuy.CrudCRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BuyRepositoryImpl implements BuyRepository {

    CrudCRepository crudCRepository;

    public BuyRepositoryImpl(CrudCRepository crudCRepository) {
        this.crudCRepository = crudCRepository;
    }

    @Override
    public List<CompraDto> getAll(){
        List<CompraDto> compraList = new ArrayList<>();
        List<CompraEntity> compraEntityList = crudCRepository.findAll();
        compraEntityList.forEach(compraEntity -> {
            CompraDto compras = new CompraDto(
                    compraEntity.getIdBuy(),
                    compraEntity.getFechaCompra(),
                    compraEntity.getCc(),
                    compraEntity.getPlaca()
            );
            compraList.add(compras);
        });
        return compraList;
    }


    public Integer save(CompraDto compraDto, PersonDto personDto, VehicleDto vehicleDto){

        CompraDto compraDto1 = new CompraDto(
                null,
                compraDto.getFechaCompra(),
                personDto.getCc(),
                vehicleDto.getPlaca()
        );
        return crudCRepository.save(compraDto).getIdBuy();
    }
}

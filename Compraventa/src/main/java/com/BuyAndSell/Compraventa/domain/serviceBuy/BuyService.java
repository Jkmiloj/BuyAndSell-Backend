package com.BuyAndSell.Compraventa.domain.serviceBuy;
import com.BuyAndSell.Compraventa.domain.CompraDto;
import com.BuyAndSell.Compraventa.domain.PersonDto;
import com.BuyAndSell.Compraventa.domain.VehicleDto;
import com.BuyAndSell.Compraventa.persistence.repositiryImplBuy.BuyRepositoryImpl;
import com.BuyAndSell.Compraventa.persistence.repositoryBuy.BuyRepository;
import com.BuyAndSell.Compraventa.persistence.repositoryImplPerson.PersonRepositoryImpl;
import com.BuyAndSell.Compraventa.persistence.repositoryImplVehicle.VehicleRepositoryImpl;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BuyService implements BuyRepository {

    BuyRepositoryImpl buyRepository;
    VehicleRepositoryImpl vehicleRepository;
    PersonRepositoryImpl personRepository;

    public BuyService(BuyRepositoryImpl buyRepository) {
        this.buyRepository = buyRepository;
    }

    @Override
    public List<CompraDto> getAll() {
        return buyRepository.getAll();
    }
    @Override
    public Integer save(CompraDto compraDto){
        PersonDto personDto = personRepository.findById(compraDto.getCc()).orElse(null);
        VehicleDto vehicleDto = vehicleRepository.findById(compraDto.getPlaca()).orElse(null);

        if (personDto != null && vehicleDto != null){
            compraDto.setPersonDto(personDto);
            compraDto.setVehiculoDto(vehicleDto);
        }
        return buyRepository.save(compraDto);
    }
}

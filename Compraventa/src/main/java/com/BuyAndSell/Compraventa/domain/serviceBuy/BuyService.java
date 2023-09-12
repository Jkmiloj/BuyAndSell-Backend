package com.BuyAndSell.Compraventa.domain.serviceBuy;
import com.BuyAndSell.Compraventa.domain.CompraDto;
import com.BuyAndSell.Compraventa.domain.PersonDto;
import com.BuyAndSell.Compraventa.domain.VehicleDto;
import com.BuyAndSell.Compraventa.persistence.entitiesPerson.PersonaEntity;
import com.BuyAndSell.Compraventa.persistence.entitiesVehicle.VehiculoEntity;
import com.BuyAndSell.Compraventa.persistence.repositiryImplBuy.BuyRepositoryImpl;
import com.BuyAndSell.Compraventa.persistence.repositoryBuy.BuyRepository;
import com.BuyAndSell.Compraventa.persistence.repositoryImplPerson.PersonRepositoryImpl;
import com.BuyAndSell.Compraventa.persistence.repositoryImplVehicle.VehicleRepositoryImpl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import static com.BuyAndSell.Compraventa.domain.serviceVehicle.VehicleService.validarPlacaCarro;
import static com.BuyAndSell.Compraventa.domain.serviceVehicle.VehicleService.validarPlacaMoto;

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
    public Integer save(CompraDto compraDto, PersonDto personDto, VehicleDto vehicleDto){

        Optional<PersonaEntity> personExist = personRepository.findById(personDto.getCc());
        Optional<VehiculoEntity> placaExist = vehicleRepository.findById(vehicleDto.getPlaca());
        if (personDto.getCc() == null && vehicleDto.getPlaca() == null || vehicleDto.getPlaca().isEmpty()){
            throw new IllegalArgumentException("El documento y la placa no deben estar vacios");
        }
        if (personDto.getCc() < 1){
            throw new IllegalArgumentException("No se permiten valores negativos");
        }
        String ccString = String.valueOf(personDto.getCc());

        if (ccString.length() >= 7 && ccString.length() <= 10) {
           if (personExist.isPresent() && placaExist.isPresent()) {
               if (validarPlacaCarro(vehicleDto.getPlaca()) || validarPlacaMoto(vehicleDto.getPlaca())){
                   return buyRepository.save(compraDto, personDto, vehicleDto);
                   /*VehicleDto.updateByStateV(vehicleDto.getPlaca(), vehicleDto.setEstado("V"));*/
               } else {
                   throw new IllegalArgumentException("Formato de placa invalido");
               }

           } else {
               throw new IllegalArgumentException("El numero de documento y placa no se encuentran registrados");
           }

        } else {
             throw new IllegalArgumentException("La identificación debe de tener entre 7 y 10 dígitos");
        }
    }
}



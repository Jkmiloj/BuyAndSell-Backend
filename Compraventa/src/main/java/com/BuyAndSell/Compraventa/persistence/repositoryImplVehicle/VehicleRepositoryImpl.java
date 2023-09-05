package com.BuyAndSell.Compraventa.persistence.repositoryImplVehicle;
import com.BuyAndSell.Compraventa.domain.Vehicles;
import com.BuyAndSell.Compraventa.persistence.entitiesVehicle.VehiculoEntity;
import com.BuyAndSell.Compraventa.persistence.repositoryVehicle.CrudVRepository;
import com.BuyAndSell.Compraventa.persistence.repositoryVehicle.VehicleRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    CrudVRepository crudVRepository;

    public VehicleRepositoryImpl(CrudVRepository crudVRepository) {
        this.crudVRepository = crudVRepository;
    }

    public List<Vehicles> getAll(){
        List<Vehicles> vehicleList = new ArrayList<>();
        List<VehiculoEntity> vehiculoEntityList = crudVRepository.findAll();
        vehiculoEntityList.forEach(vehiculoEntity -> {
            Vehicles vehicles = new Vehicles(
                 vehiculoEntity.getPlaca(),
                 vehiculoEntity.getTipo(),
                 vehiculoEntity.getCilindraje(),
                 vehiculoEntity.getModelo(),
                 vehiculoEntity.getMarca(),
                 vehiculoEntity.getCiudad(),
                 vehiculoEntity.getEstado()
            );
            vehicleList.add(vehicles);
        });
        return vehicleList;
    }
}

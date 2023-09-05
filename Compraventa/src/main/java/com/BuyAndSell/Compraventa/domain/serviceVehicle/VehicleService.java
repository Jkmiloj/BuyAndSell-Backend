package com.BuyAndSell.Compraventa.domain.serviceVehicle;
import com.BuyAndSell.Compraventa.domain.Vehicles;
import com.BuyAndSell.Compraventa.persistence.repositoryImplVehicle.VehicleRepositoryImpl;
import com.BuyAndSell.Compraventa.persistence.repositoryVehicle.VehicleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService implements VehicleRepository {
    VehicleRepositoryImpl vehicleRepository;

    public VehicleService(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicles> getAll(){
        return vehicleRepository.getAll();
    }
}

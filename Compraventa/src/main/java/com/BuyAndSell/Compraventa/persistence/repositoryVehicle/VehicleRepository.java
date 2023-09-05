package com.BuyAndSell.Compraventa.persistence.repositoryVehicle;
import com.BuyAndSell.Compraventa.domain.Vehicles;
import com.BuyAndSell.Compraventa.persistence.entitiesVehicle.VehiculoEntity;
import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    List<Vehicles> getAll();

    List<Vehicles> getByEstadoV(String estado);

    Optional<VehiculoEntity> findById(String placa);

    List<Vehicles> getByPlaca(String placa);

    String update(Vehicles vehicles, String placa);

    String save(Vehicles vehicles);

}

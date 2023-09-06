package com.BuyAndSell.Compraventa.persistence.repositoryImplVehicle;
import com.BuyAndSell.Compraventa.domain.Vehicles;
import com.BuyAndSell.Compraventa.persistence.entitiesVehicle.VehiculoEntity;
import com.BuyAndSell.Compraventa.persistence.repositoryVehicle.CrudVRepository;
import com.BuyAndSell.Compraventa.persistence.repositoryVehicle.VehicleRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    CrudVRepository crudVRepository;

    public VehicleRepositoryImpl(CrudVRepository crudVRepository) {
        this.crudVRepository = crudVRepository;
    }

    @Override
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

    @Override
    public List<Vehicles> getByEstadoV(String estado){
        List<Vehicles> vehicleList = new ArrayList<>();
        List<VehiculoEntity> vehiculoEntityList = crudVRepository.getByEstadoV(estado);
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

    @Override
    public Optional<VehiculoEntity> findById(String placa){
        return crudVRepository.findById(placa);
    }

    @Override
    public List<Vehicles> getByPlaca(String placa){
        List<Vehicles> vehicleList = new ArrayList<>();
        List<VehiculoEntity> vehiculoEntityList = crudVRepository.getByPlaca(placa);
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

    @Override
    public String update(Vehicles vehicles, String placa){
        VehiculoEntity vehiculoEntity = new VehiculoEntity(
            vehicles.getPlaca(),
            vehicles.getTipo(),
            vehicles.getCilindraje(),
            vehicles.getModelo(),
            vehicles.getMarca(),
            vehicles.getCiudad(),
            vehicles.getEstado()
        );
        return crudVRepository.save(vehiculoEntity).getPlaca();
    }

    @Override
    public String save(Vehicles vehicles){
        VehiculoEntity vehiculoEntity = new VehiculoEntity(
                vehicles.getPlaca().toUpperCase(),
                vehicles.getTipo(),
                vehicles.getCilindraje(),
                vehicles.getModelo(),
                vehicles.getMarca(),
                vehicles.getCiudad(),
                vehicles.getEstado()
        );
        return crudVRepository.save(vehiculoEntity).getPlaca();
    }

    @Override
    public void updateE(String placa, String newestado){
        Optional<VehiculoEntity> personEntityOptional = crudVRepository.findById(placa);

        if (personEntityOptional.isPresent()) {
            VehiculoEntity vehiculoEntity = personEntityOptional.get();
            vehiculoEntity.setEstado(newestado);
            crudVRepository.save(vehiculoEntity);
        } else {
            throw new IllegalArgumentException("No se puede actualizar, la placa no existe.");
        }
    }

    @Override
    public String save2(VehiculoEntity personaEntity) {
        personaEntity.getPlaca();
        personaEntity.getEstado();
        return crudVRepository.save(personaEntity).getPlaca();
    }
}

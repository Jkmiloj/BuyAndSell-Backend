package com.BuyAndSell.Compraventa.domain.serviceVehicle;
import com.BuyAndSell.Compraventa.domain.Vehicles;
import com.BuyAndSell.Compraventa.persistence.entitiesVehicle.VehiculoEntity;
import com.BuyAndSell.Compraventa.persistence.repositoryImplVehicle.VehicleRepositoryImpl;
import com.BuyAndSell.Compraventa.persistence.repositoryVehicle.VehicleRepository;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class VehicleService implements VehicleRepository {
    VehicleRepositoryImpl vehicleRepository;

    public VehicleService(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    private final String[] estadoListV = {"A","I"};
    private final String[] tipoV = {"Moto","Carro"};
    @Override
    public List<Vehicles> getAll(){
        return vehicleRepository.getAll();
    }

    @Override
    public List<Vehicles> getByEstadoV(String estado){
        if (estado == null || estado.isEmpty()){
            throw new IllegalArgumentException("Se debe de ingresar un estado");
        }
        if(!Arrays.stream(estadoListV).anyMatch(state -> state.equals(estado))){
            throw new RuntimeException("El estado no es válido, debe ingresar A o I");
        }
        return vehicleRepository.getByEstadoV(estado);
    }

    @Override
    public Optional<VehiculoEntity> findById(String placa){
        return Optional.empty();
    }

    @Override
    public List<Vehicles> getByPlaca(String placa){
        if (placa == null || placa.isEmpty()){
            throw new IllegalArgumentException("Debe ingresar una placa");
        }
        Optional<VehiculoEntity> placaExist = vehicleRepository.findById(placa);

        if (validarPlacaCarro(placa) || validarPlacaMoto(placa)){
           if (placaExist.isPresent()) {
               return vehicleRepository.getByPlaca(placa);
           }else {
                throw new IllegalArgumentException("La PLaca no existe");
           }
        }else {
            throw new IllegalArgumentException("Formato de placa invalido");
        }
    }


    public static boolean validarPlacaCarro(String placa) {

        String patron = "^[A-Za-z]{3}\\d{3}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(placa.toUpperCase());
        return matcher.matches();
    }

    public static boolean validarPlacaMoto(String placa) {

        String patron = "^[A-Za-z]{3}\\d{2}[A-Za-z]$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(placa.toUpperCase());
        return matcher.matches();
    }

    @Override
    public String update(Vehicles vehicles, String placa){
        Optional<VehiculoEntity> placaExist = vehicleRepository.findById(placa);

        if (placaExist.isEmpty()){
            throw new IllegalArgumentException("La placa no se encuentra registrada");
        }
        return vehicleRepository.update(vehicles, placa);

        /*if (validarPlacaCarro(placa) || validarPlacaMoto(placa)){
            return vehicleRepository.update(vehicles, placa);
        }else {
            throw new IllegalArgumentException("Formato de placa invalido");
        }*/
    }

    @Override
    public String save(Vehicles vehicles){
        if (vehicles.getPlaca() == null || vehicles.getPlaca().isEmpty()){
            throw new IllegalArgumentException("Debe ingresar una placa");
        }
        if (!Arrays.stream(tipoV).anyMatch(state -> state.equals(vehicles.getTipo()))){
            throw new IllegalArgumentException("Tipo de vehiculo no valido, debe ser Moto o Carro");
        }
        Optional<VehiculoEntity> placaExist = vehicleRepository.findById(vehicles.getPlaca().toUpperCase());
        if (vehicles.getCilindraje() >= 99){
            if (validarPlacaCarro(vehicles.getPlaca()) || validarPlacaMoto(vehicles.getPlaca())){
                if (placaExist.isPresent()) {
                    throw new IllegalArgumentException("La PLaca se encuentra registrada");
                }else {
                    return vehicleRepository.save(vehicles);
                }
            }else {
                throw new IllegalArgumentException("Formato de placa invalido");
            }
        } else {
            throw new IllegalArgumentException("El cilindraje no es válido");
        }
    }
}

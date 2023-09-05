package com.BuyAndSell.Compraventa.controller.vehicle;
import com.BuyAndSell.Compraventa.domain.Vehicles;
import com.BuyAndSell.Compraventa.domain.serviceVehicle.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class VehicleDto {
    VehicleService vehicleService;

    public VehicleDto(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(value = "/traer-vehiculos")
    public List<Vehicles> getAll(){
        return vehicleService.getAll();
    }

    @GetMapping(value = "/estadovehiculo/{estado}")
    public List<Vehicles> getByEstadoV(@PathVariable("estado") String estado) {
        return vehicleService.getByEstadoV(estado);
    }
    @GetMapping(value = "/traer-placa/{placa}")
    public List<Vehicles> getByPlaca(@PathVariable("placa") String placa){
        return vehicleService.getByPlaca(placa.toUpperCase());
    }

    @PutMapping(value = "/actualizar-vehiculo")
    public String update(@RequestBody Vehicles vehicles){
        return vehicleService.update(vehicles, vehicles.getPlaca());
    }

    @PostMapping(value = "/crear-vehiculo")
    public String save(@RequestBody Vehicles vehicles){
        return vehicleService.save(vehicles);
    }
}

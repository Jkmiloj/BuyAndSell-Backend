package com.BuyAndSell.Compraventa.controller.vehicle;
import com.BuyAndSell.Compraventa.domain.Vehicles;
import com.BuyAndSell.Compraventa.domain.serviceVehicle.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
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
}

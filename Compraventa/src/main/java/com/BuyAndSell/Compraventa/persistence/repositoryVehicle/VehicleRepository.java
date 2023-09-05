package com.BuyAndSell.Compraventa.persistence.repositoryVehicle;

import com.BuyAndSell.Compraventa.domain.Vehicles;

import java.util.List;

public interface VehicleRepository {
    public List<Vehicles> getAll();
}

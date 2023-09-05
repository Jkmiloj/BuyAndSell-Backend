package com.BuyAndSell.Compraventa.persistence.repositoryVehicle;
import com.BuyAndSell.Compraventa.persistence.entitiesVehicle.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CrudVRepository extends JpaRepository<VehiculoEntity,String> {
  List<VehiculoEntity> findAll();
}

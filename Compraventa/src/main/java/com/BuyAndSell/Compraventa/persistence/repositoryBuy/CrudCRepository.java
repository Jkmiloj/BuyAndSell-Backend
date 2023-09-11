package com.BuyAndSell.Compraventa.persistence.repositoryBuy;
import com.BuyAndSell.Compraventa.persistence.entitiesBuy.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CrudCRepository extends JpaRepository<CompraEntity, Integer> {
    List<CompraEntity> findAll();
}

package com.BuyAndSell.Compraventa.persistence.repositoryPerson;
import com.BuyAndSell.Compraventa.domain.Persons;
import com.BuyAndSell.Compraventa.persistence.entitiesPerson.PersonaEntity;
import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    List<Persons> getAll();

    List<Persons> getByEstado(String estado);

    Optional<PersonaEntity> findById(Integer cc);

    List<Persons> getByCc(Integer cc);

    Integer update(Persons persons, Integer cc);

    Integer save(Persons persons);

    void update2(Integer cc, String newestado);

    Integer save2(PersonaEntity personaEntity);
}

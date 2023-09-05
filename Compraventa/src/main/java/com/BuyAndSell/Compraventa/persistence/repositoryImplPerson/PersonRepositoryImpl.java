package com.BuyAndSell.Compraventa.persistence.repositoryImplPerson;
import com.BuyAndSell.Compraventa.domain.Persons;
import com.BuyAndSell.Compraventa.persistence.entitiesPerson.PersonaEntity;
import com.BuyAndSell.Compraventa.persistence.repositoryPerson.CrudRepository;
import com.BuyAndSell.Compraventa.persistence.repositoryPerson.PersonRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    CrudRepository crudRepository;

    public PersonRepositoryImpl(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public List<Persons> getAll(){
        List<Persons> personList = new ArrayList<>();
        List<PersonaEntity> personaEntityList = crudRepository.findAll();
        personaEntityList.forEach(personaEntity -> {
            Persons persons = new Persons(
                personaEntity.getCc(),
                personaEntity.getNombre(),
                personaEntity.getApellido1(),
                personaEntity.getApellido2(),
                personaEntity.getEdad(),
                personaEntity.getGenero(),
                personaEntity.getEstado()
            );
            personList.add(persons);
        });
        return personList;
    }

    @Override
    public List<Persons> getByEstado(String estado){
        List<Persons> personList = new ArrayList<>();
        List<PersonaEntity> personaEntityList = crudRepository.getByEstado(estado);
        personaEntityList.forEach(personaEntity -> {
            Persons persons = new Persons(
                    personaEntity.getCc(),
                    personaEntity.getNombre(),
                    personaEntity.getApellido1(),
                    personaEntity.getApellido2(),
                    personaEntity.getEdad(),
                    personaEntity.getGenero(),
                    personaEntity.getEstado()
            );
            personList.add(persons);
        });
        return personList;
    }

    @Override
    public Optional<PersonaEntity> findById(Integer cc){
        return crudRepository.findById(cc);
    }

    @Override
    public List<Persons> getByCc(Integer cc){
        List<Persons> personList = new ArrayList<>();
        List<PersonaEntity> personaEntityList = crudRepository.getByCc(cc);
        personaEntityList.forEach(personaEntity -> {
            Persons persons = new Persons(
                    personaEntity.getCc(),
                    personaEntity.getNombre(),
                    personaEntity.getApellido1(),
                    personaEntity.getApellido2(),
                    personaEntity.getEdad(),
                    personaEntity.getGenero(),
                    personaEntity.getEstado()
            );
            personList.add(persons);
        });
        return personList;
    }

    @Override
    public Integer update(Persons persons, Integer cc){
        PersonaEntity personaEntity = new PersonaEntity(
                persons.getCc(),
                persons.getNombre(),
                persons.getApellido1(),
                persons.getApellido2(),
                persons.getEdad(),
                persons.getGenero(),
                persons.getEstado()
        );
        return crudRepository.save(personaEntity).getCc();
    }

    @Override
    public Integer save(Persons persons){
        PersonaEntity personaEntity = new PersonaEntity(
                persons.getCc(),
                persons.getNombre(),
                persons.getApellido1(),
                persons.getApellido2(),
                persons.getEdad(),
                persons.getGenero(),
                persons.getEstado()
        );
        return crudRepository.save(personaEntity).getCc();
    }

    @Override
    public void update2(Integer cc, String newestado){
        Optional<PersonaEntity> personEntityOptional = crudRepository.findById(cc);

        if (personEntityOptional.isPresent()) {
            PersonaEntity personEntity = personEntityOptional.get();
            personEntity.setEstado(newestado);
            crudRepository.save(personEntity);
        } else {
            throw new IllegalArgumentException("No se puede actualizar, la cédula no existe.");
        }
    }

    @Override
    public Integer save2(PersonaEntity personaEntity) {
        personaEntity.getCc();
        personaEntity.getEstado();
        return crudRepository.save(personaEntity).getCc();
    }
}


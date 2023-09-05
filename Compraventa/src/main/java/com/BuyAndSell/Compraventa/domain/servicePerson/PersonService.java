package com.BuyAndSell.Compraventa.domain.servicePerson;
import com.BuyAndSell.Compraventa.domain.Persons;
import com.BuyAndSell.Compraventa.persistence.entitiesPerson.PersonaEntity;
import com.BuyAndSell.Compraventa.persistence.repositoryImplPerson.PersonRepositoryImpl;
import com.BuyAndSell.Compraventa.persistence.repositoryPerson.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonRepository {

    PersonRepositoryImpl personRepository;

    public PersonService(PersonRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }

    private final String[] estadoList = {"A","I"};
    private final static String[] generoList = {"F","M"};
    @Override
    public List<Persons> getAll(){
        return personRepository.getAll();
    }

    @Override
    public List<Persons> getByEstado(String estado){
        if (estado == null || estado.isEmpty()){
            throw new IllegalArgumentException("Se debe de ingresar un estado");
        }

        if(!Arrays.stream(estadoList).anyMatch(state -> state.equals(estado))){
            throw new RuntimeException("El estado no es válido, debe ingresar A o I");
        }
        return personRepository.getByEstado(estado);
    }

    @Override
    public Optional<PersonaEntity> findById(Integer cc){
        return Optional.empty();
    }
    @Override
    public List<Persons> getByCc(Integer cc){
        if(cc == null){
            throw new IllegalArgumentException("Debe ingresar un numero de documento de identidad");
        }
        if (cc < 1){
            throw new IllegalArgumentException("No se permiten valores negativos");
        }
        String ccString = String.valueOf(cc);
        Optional<PersonaEntity> personExist = personRepository.findById(cc);
        if(ccString.length()>=7 && ccString.length() <=10){
            if(personExist.isEmpty()){
                throw new IllegalArgumentException("El numero de documento no se encuentra registrado");
            } else  {
                return personRepository.getByCc(cc);
            }
        } else{
               throw new IllegalArgumentException("La identificación debe de tener entre 7 y 10 digitos");
               }
    }

    @Override
    public Integer update(Persons persons, Integer cc){
        Optional<PersonaEntity> personExist = personRepository.findById(cc);
        if (personExist.isEmpty()){
            throw new IllegalArgumentException("El numero de documento no se encuentra registrado");
        }
        return personRepository.update(persons,cc);
    }

    @Override
    public Integer save(Persons persons){
        if (persons.getCc() == null){
            throw new IllegalArgumentException("El documento no debe estar vacio");
        }
        if (persons.getCc() < 1){
            throw new IllegalArgumentException("No se permiten valores negativos");
        }
        String ccString = String.valueOf(persons.getCc());
        Optional<PersonaEntity> personExist = personRepository.findById(persons.getCc());
        if (persons.getEdad() >= 18){
            if (ccString.length() >= 7 && ccString.length() <= 10) {
                if (personExist.isPresent()) {
                    throw new IllegalArgumentException("El numero de documento se encuentra registrado");
                } else {
                    return personRepository.save(persons);
                }
            } else {
                    throw new IllegalArgumentException("La identificación debe de tener entre 7 y 10 dígitos");
            }
        } else {
                throw new IllegalArgumentException("Debes de ser mayor de edad");
        }
    }

    @Override
    public void update2(Integer cc, String newestado){
        if (cc == null || newestado == null || newestado.isEmpty()){
            throw new IllegalArgumentException("La cédula y el género son obligatorios");
        }
        Optional<PersonaEntity> personExist = personRepository.findById(cc);
        if (personExist.isEmpty()){
            throw new IllegalArgumentException("No se puede actualizar, la cédula no existe");
        }
        String ccString = String.valueOf(cc);
        if (ccString.length() >= 7 && ccString.length() <= 10) {
            if (personExist.isPresent()){
                if (!Arrays.asList("A","I").contains(newestado.toUpperCase())){
                    throw new IllegalArgumentException("El género no es valido");
                }
                PersonaEntity personaEntity = personExist.get();
                personaEntity.setEstado(newestado.toUpperCase());
                personRepository.save2(personaEntity);
            }
        }
    }

    @Override
    public Integer save2(PersonaEntity personaEntity) {
        return personRepository.save2(personaEntity);
    }
}
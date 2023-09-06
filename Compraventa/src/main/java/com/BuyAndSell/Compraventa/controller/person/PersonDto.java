package com.BuyAndSell.Compraventa.controller.person;
import com.BuyAndSell.Compraventa.domain.Persons;
import com.BuyAndSell.Compraventa.domain.servicePerson.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class PersonDto {

    PersonService personService;

    public PersonDto(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/traer-todo")
    public List<Persons> getAll(){
        return personService.getAll();
    }

    @GetMapping(value = "/estado/{estado}")
    public List<Persons> getByEstado(@PathVariable("estado") String estado){
        return personService.getByEstado(estado);
    }

    @GetMapping(value = "/documento/{cc}")
    public List<Persons> getByCc(@PathVariable("cc") Integer cc){
        return personService.getByCc(cc);
    }

    @PutMapping(value = "/actualizar")
    public Integer update (@RequestBody Persons persons, Integer cc){
        return personService.update(persons, persons.getCc());
    }

    @PostMapping(value = "/crear")
    public Integer save(@RequestBody Persons persons){
            return personService.save(persons);
    }
    @PutMapping(value = "/actualizar-estado/{cc}")
    public ResponseEntity<String> update2(@PathVariable("cc") Integer cc, @RequestBody Map<String, String> requestBody){
        String newestado = requestBody.get("estado");

        if (newestado == null || newestado.isEmpty()){
            return ResponseEntity.badRequest().body("El campo estado no puede estar vacio");
        }
        try {
            personService.update2(cc,newestado);
            return ResponseEntity.ok("Estado actualizado");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

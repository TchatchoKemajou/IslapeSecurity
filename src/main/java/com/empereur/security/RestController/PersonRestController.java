package com.empereur.security.RestController;

import com.empereur.security.Models.Personne;
import com.empereur.security.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personne")
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @GetMapping("/allstudent")
    public List<Personne> allStudent(){
        return personService.findAllEtudiant();
    }

    @GetMapping("/allemployees")
    public List<Personne> allEmployee(){
        return  personService.findAllEmployee();
    }

    @PostMapping("/savepersonne")
    public Personne save(@RequestBody Personne personne){return  personService.savePerson(personne);}

    @PutMapping("/desactivatecard/{id}")
    public Personne desactivateCard(@PathVariable Long id){return personService.desactivateCard(id);}
}

package com.empereur.security.Services;

import com.empereur.security.Models.Personne;
import com.empereur.security.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Personne> findAllEtudiant(){
        return  personRepository.findAllByPersonType("student");
    }

    public List<Personne> findAllEmployee(){
        return  personRepository.findAllByPersonType("employee");
    }

    public  Personne savePerson(Personne personne){return personRepository.save(personne);};

    public  Personne desactivateCard(Long id){
        Personne personne = personRepository.getById(id);
        Personne newPerson = personne;

        if(personne.isStatusCard() == true){
            newPerson.setStatusCard(false);
        }else {
            newPerson.setStatusCard(true);
        }


        return  personRepository.save(newPerson);
    }

    public Personne findPersonByCode(String code){
        List<Personne> personList = personRepository.findAll();

        for (Personne personne:personList){
            if (personne.getCode().equals(code) && personne.isStatusCard() == true){
                return  personne;
            }
        }
        return  null;
    }
}

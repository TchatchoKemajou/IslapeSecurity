package com.empereur.security.Services;

import com.empereur.security.Models.Personne;
import com.empereur.security.Models.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteService {

    @Autowired
    private VisitServices visitServices;

    @Autowired
    private PersonService personService;

    @Autowired
    private TraficService traficService;

//    @Autowired
//    private HistoryServices historyServices;

    public boolean ScanAndVerifyCarte(Long site, String code){
        if(visitServices.findVisitByCarteTemp(code) != null || personService.findPersonByCode(code) != null){
            if (visitServices.findVisitByCarteTemp(code) != null){
                Visite visite = visitServices.findVisitByCarteTemp(code);
//                Historique historique = new Historique();
//                historique.setHisInfosId(visite.getVisitId());
//                historyServices.saveHistory(historique);
                //traficService.saveTrafic(visite.getVisitorId().getVisitorID());
            }else {
                Personne personne = personService.findPersonByCode(code);
                traficService.saveTrafic(personne.getPersonId(), site);
            }
            return  true;
        }
        return  false;
    }

}

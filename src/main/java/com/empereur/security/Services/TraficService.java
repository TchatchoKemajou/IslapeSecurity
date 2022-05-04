package com.empereur.security.Services;

import com.empereur.security.Models.Trafic;
import com.empereur.security.Repository.PersonRepository;
import com.empereur.security.Repository.SiteRepository;
import com.empereur.security.Repository.TraficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TraficService {
    @Autowired
    private TraficRepository traficRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SiteRepository siteRepository;

    public Trafic saveTrafic(Long idPerson, Long idSite){
        Trafic trafic = new Trafic();

        trafic.setPerson(personRepository.getById(idPerson));
        trafic.setTraficSite(siteRepository.getById(idSite));
        trafic.setTraficDay(new java.sql.Date(new Date().getTime()));
        trafic.setTraficTime(String.valueOf(new java.sql.Time(new Date().getTime())));
        return traficRepository.save(trafic);
    }

    public  List<Trafic> findAllTrafic(Long id){return traficRepository.findAllByTraficSite(siteRepository.getById(id));}

    public List<Trafic> findAllTraficOfDay(Long id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Trafic> traficList = traficRepository.findAllByTraficSite(siteRepository.getById(id));
        List<Trafic> trafics = new ArrayList<>();
        for(Trafic trafic: traficList){
            if(sdf.format(trafic.getTraficDay()).equals((LocalDate.now()).toString())){
                trafics.add(trafic);
            }else  return  null;
        }
        return  trafics;
    }


}

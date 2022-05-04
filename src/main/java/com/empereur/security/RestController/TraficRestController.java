package com.empereur.security.RestController;

import com.empereur.security.Models.Trafic;
import com.empereur.security.Services.TraficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trafic")
public class TraficRestController {

    @Autowired
    private TraficService traficService;

    @GetMapping("/alltrafic/{id}")
    public List<Trafic> findAllTrafic(@PathVariable Long id){return traficService.findAllTrafic(id);}

    @GetMapping("/alltraficofday/{id}")
    public List<Trafic> findAllTraficOfDay(@PathVariable Long id){return traficService.findAllTraficOfDay(id);}

}

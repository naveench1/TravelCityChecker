package com.travel.cityApplication.cityController;

import com.travel.cityApplication.cityService.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    public CityController(CityServiceImpl cityService){
        this.cityService = cityService;
    }

    /* Controller that returns yes if two cities are connected otherwise returns no.*/
    @GetMapping("/${urlName}")
    public String getConnectedCityDetails(@RequestParam(name="source") String source, @RequestParam(name="destination") String destination){
        String response = cityService.checkIfCitiesConnected(source, destination);
        return response;
    }
}

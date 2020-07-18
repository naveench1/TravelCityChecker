package com.travel.cityApplication.cityService;

import com.travel.cityApplication.cityModel.City;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CityServiceImplTest {

    /* Test that validates if there is data in the file.*/
    @Test
    public void getServiceData() {
        CityServiceImpl cityServiceImpl = new CityServiceImpl();
        List<City> response = cityServiceImpl.getCityListData();
        assertTrue(response.size()>0);
    }

    /* Tests that returns yes if there is a match between input and text file city names*/
    @Test
    public void checkIfCitiesConnected(){
        CityServiceImpl cityServiceImpl = new CityServiceImpl();
        String response = cityServiceImpl.checkIfCitiesConnected("Newark","Boston");
        assertEquals("yes",response);
    }

    /* Tests that returns no if there is no match between input and text file city names*/
    @Test
    public void checkIfCitiesDisConnected() {
        CityServiceImpl cityServiceImpl = new CityServiceImpl();
        String response = cityServiceImpl.checkIfCitiesConnected("Newwark","Boston");
        assertEquals("no",response);
    }

}


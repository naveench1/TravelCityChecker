package com.travel.cityApplication.cityController;

import com.travel.cityApplication.cityModel.City;
import com.travel.cityApplication.cityService.CityServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityControllerTest{

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    CityServiceImpl cityServiceImpl = new CityServiceImpl();

    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /* Tests Controller that returns no if two cities are not available in the file.*/
    @Test
    public void getDisconnectedCityDetails() {
        CityController cityController = new CityController(cityServiceImpl);
        String response = cityController.getConnectedCityDetails("Newwark","Boston");
        assertEquals("no",response);
    }

    /* Tests Controller that returns yes if two cities are available in the file.*/
    @Test
    public void getConnectedCityDetails() {
        CityController cityController = new CityController(cityServiceImpl);
        String response = cityController.getConnectedCityDetails("Newark"," Boston");
        assertEquals("yes",response);
    }

}


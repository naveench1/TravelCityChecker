package com.travel.cityApplication.cityService;

import com.travel.cityApplication.cityModel.City;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl {

    List<City> cityList= new ArrayList<>();

    /* Reads all the values from a text file. Splits the values in each line with delimiter ','
     and will be mapped as source and destination cities to compare in City class*/
    public List<City> getCityListData(){
        String line;
        String [] cityData;
        try {
            String fileName = "city.txt";
            Path path = Paths.get("src/main/resources/city.txt");
            BufferedReader br = Files.newBufferedReader(path);
            while((line=br.readLine())!=null){
                cityData = line.split(",");
                City city = new City();
                city.setSource(cityData[0]);
                city.setDestination(cityData[1]);
                cityList.add(city);
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }

        return cityList;
    }

    /* Checks if the two cities from input matches with the text file data.*/
    public String checkIfCitiesConnected(String source, String destination){
        String result = "no";
        cityList = getCityListData();

        for (City c: cityList) {
            if((c.getSource().trim().equals(source.trim())) && (c.getDestination().trim().equals(destination.trim()))){
                result="yes";
                break;
            }
        }
        return result;
    }
}

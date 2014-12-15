package hello.controllers;

/**
 * Created by silvian on 14/12/14.
 */

import hello.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class WeatherClientController {

    @Autowired
    WeatherService weatherService;



    @RequestMapping(value = "/weather",
                    method = RequestMethod.GET)
    public String displayWeather(ModelMap modelMap) {

        return "weather";

    }

    @RequestMapping(value = "get-weather-data",
                    method = RequestMethod.GET)
    public String getWeatherDataAction(@RequestParam(value = "zip-code") String zipCode) {


        weatherService.processWeather(zipCode);

        return "weather";
    }

}

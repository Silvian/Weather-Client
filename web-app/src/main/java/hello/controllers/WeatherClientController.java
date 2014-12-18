package hello.controllers;

/**
 * Created by silvian on 14/12/14.
 */

import hello.models.WeatherDataModel;
import hello.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView processWeatherData(@RequestParam(value = "zip-code")
                                         String zipCode, ModelMap model) {

        String city;
        city = weatherService.getWeatherForecastCity(zipCode);
        model.addAttribute("city", city);

        List<WeatherDataModel> weatherDataModelList;
        weatherDataModelList = weatherService.getWeatherForecastData(zipCode);
        model.addAttribute("weatherDataModelList", weatherDataModelList);

        return new ModelAndView("weather", model);
    }

}

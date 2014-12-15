package hello.services;

import hello.WeatherClient;
import hello.wsdl.GetCityForecastByZIPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by silvian on 15/12/14.
 */
@Service
public class WeatherService {


    @Autowired
    WeatherClient weatherClient;


    public void processWeather(String zipCode) {

        GetCityForecastByZIPResponse response = weatherClient.getCityForecastByZip(zipCode);
        weatherClient.printResponse(response);
    }

    public List getWeatherData(GetCityForecastByZIPResponse response) {

        return response.getGetCityForecastByZIPResult().getForecastResult().getForecast();
    }

}

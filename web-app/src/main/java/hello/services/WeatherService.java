package hello.services;

import hello.WeatherClient;
import hello.models.WeatherDataModel;
import hello.wsdl.Forecast;
import hello.wsdl.ForecastReturn;
import hello.wsdl.GetCityForecastByZIPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by silvian on 15/12/14.
 */
@Service
public class WeatherService {


    @Autowired
    WeatherClient weatherClient;


    private ForecastReturn processWeather(String zipCode) {

        GetCityForecastByZIPResponse response = weatherClient.getCityForecastByZip(zipCode);

        ForecastReturn forecastReturn = response.getGetCityForecastByZIPResult();
        return forecastReturn;
    }

    public String getWeatherForecastCity(String zipCode) {

        ForecastReturn forecastReturn = processWeather(zipCode);

        if (forecastReturn.isSuccess()) {

            return "Forecast for: " + forecastReturn.getCity() + ", "
                    + forecastReturn.getState();
        }

        return "No Forecast Available";
    }

    public List<WeatherDataModel> getWeatherForecastData(String zipCode) {

        ForecastReturn forecastReturn = processWeather(zipCode);
        if(forecastReturn.isSuccess()) {
            List<WeatherDataModel> weatherDataModelList = new ArrayList<WeatherDataModel>();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for(Forecast forecast: forecastReturn.getForecastResult().getForecast()){
                weatherDataModelList.add(new WeatherDataModel(formatter.format(forecast.getDate().toGregorianCalendar().getTime()).toString(),
                                                                forecast.getDesciption(),forecast.getTemperatures().getMorningLow(),
                                                                forecast.getTemperatures().getDaytimeHigh()));
            }

            return weatherDataModelList;
        }

        return null;
    }

}

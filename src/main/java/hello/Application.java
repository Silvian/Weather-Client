package hello;

/**
 * Created by silvian on 20/11/14.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import hello.wsdl.GetCityForecastByZIPResponse;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WeatherConfiguration.class, args);

        WeatherClient weatherClient = ctx.getBean(WeatherClient.class);

        String zipCode = "94101";
        if (args.length > 0) {
            zipCode = args[0];
        }
        GetCityForecastByZIPResponse response = weatherClient.getCityForecastByZip(zipCode);
        weatherClient.printResponse(response);
    }

}

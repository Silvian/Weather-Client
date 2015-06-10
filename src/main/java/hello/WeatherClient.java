package hello;

/**
 * Created by silvian on 20/11/14.
 */


import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.GetCityForecastByZIP;
import hello.wsdl.GetCityForecastByZIPResponse;

public class WeatherClient extends WebServiceGatewaySupport {

    @Value("${weather.client.request.url}")
    String requestUrl;

    public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode) {
        GetCityForecastByZIP request = new GetCityForecastByZIP();
        request.setZIP(zipCode);

        System.out.println();
        System.out.println("Requesting forecast for " + zipCode);

        GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) getWebServiceTemplate().marshalSendAndReceive(
                request,
                new SoapActionCallback(
                        requestUrl));

        return response;
    }

}

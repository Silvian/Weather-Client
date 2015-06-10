package hello;

/**
 * Created by silvian on 20/11/14.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WeatherConfiguration {

    @Value("${weather.client.service.url}")
    String serviceUrl;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("hello.wsdl");
        return marshaller;
    }

    @Bean
    public WeatherClient weatherClient(Jaxb2Marshaller marshaller) {
        WeatherClient client = new WeatherClient();
        client.setDefaultUri(serviceUrl);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}

package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.WebAPIClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack")
public class SlaughterAppConfig {

    @Bean
    public WebAPI_GRPC_Client webAPI_grpc_client() {
        return new WebAPI_GRPC_Client();
    }
    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        restTemplate.getMessageConverters().add(converter);
        return restTemplate;
    }
}

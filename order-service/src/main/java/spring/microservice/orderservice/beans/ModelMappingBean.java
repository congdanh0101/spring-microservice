package spring.microservice.orderservice.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappingBean {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

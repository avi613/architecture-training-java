package avi.edu.rappersdelight.config;

import avi.edu.rappersdelight.repository.RapperRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration {
    @Bean
    public RapperRepository rapperRepository() {
        return new RapperRepository();
    }
}

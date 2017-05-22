package org.gluecoders.badpractices.webservices.mutation.configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.feature.LoggingFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Anand_Rajneesh on 5/21/2017.
 */
@Configuration
public class RestServer {

    @Bean
    public JacksonJsonProvider jsonProvider(){
        return new JacksonJsonProvider();
    }

    @Bean
    public LoggingFeature loggingFeature(){
        return new LoggingFeature();
    }

}

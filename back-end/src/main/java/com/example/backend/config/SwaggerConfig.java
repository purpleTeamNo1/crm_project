package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.boot.starter.autoconfigure.SpringfoxConfigurationProperties;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createApi(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(createApiInfo());
    }


    private ApiInfo createApiInfo(){
        return new ApiInfo(
                "crm project", //title
                "It's a project for a financial advisor, which is also the final project of system development course.",  //description
                "v1.0",     //version
                "http://www.shawnDeveloper.ca",     //url
                new Contact("purple_team","http://www.shawnDeveloper.ca","hawkhxf2000@gmail.com"),  //contact info
                "Apache 2.0",  //license
                "http://www.apache.org/licenses/LICENSE-2.0",  //licenseUrl
                new ArrayList<>()   //don't know what this for, so just left it default
        );
    }
}

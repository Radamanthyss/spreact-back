package com.brunob.api.spreact.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contato(){
        return new Contact(
                "Bruno B. Weiber",
                "localhost",
                "centralacessorioss@gmail.com"
        );
    }

    private ApiInfoBuilder informacoesApi(){
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Spreact - Projeto backend base spring react");
        apiInfoBuilder.description("Spreact - Projeto backend base spring react");
        apiInfoBuilder.version("0.9");
        apiInfoBuilder.termsOfServiceUrl("termo de uso: não permitido acesso a terceiros, exceto em casos especiais");
        apiInfoBuilder.license("Made by Bruno B. Weiber");
        apiInfoBuilder.licenseUrl("localhost");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detalheApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.select()
                .apis(RequestHandlerSelectors.basePackage("com.brunob.api.spreact.Controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }

}

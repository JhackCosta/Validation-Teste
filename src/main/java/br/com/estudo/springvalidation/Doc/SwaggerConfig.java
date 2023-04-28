package br.com.estudo.springvalidation.Doc;

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

    private Contact contato() {
        return new Contact(
                "Jhack Costa",
                "https://github.com/JhackCosta",
                "jhacktibia@gmail.com");
    }

    private ApiInfoBuilder informacoesApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Validation com TDD");
        apiInfoBuilder.description("API Rest-Full para usar Spring Validation junto com TDD");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licença - Estudo");
        apiInfoBuilder.licenseUrl("https://github.com/JhackCosta");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;

    }

    @Bean
    public Docket detalheApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.estudo.springvalidation.Controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}

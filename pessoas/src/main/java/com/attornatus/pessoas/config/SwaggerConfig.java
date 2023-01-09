package com.attornatus.pessoas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.attornatus.pessoas.resources"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Avaliação Desenvolvedor Back-end Attornatus")
                .description(
                        "Neste teste serão avaliados os conhecimentos em Java, banco de dados e a metodologia aplicada no desenvolvimento, arquitetura e organização da aplicação final.")
                .version("1.0.0")
                .contact(new Contact("Jean Fernandine", "https://github.com/jean-fernandine", "jfernandine@gmail.com"))
                .build();
    }
}

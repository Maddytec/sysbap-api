package br.com.maddytec.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("br.com.maddytec.resource"))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo())
          .securitySchemes(Arrays.asList(apiKey()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("System Buy and Pay")
				.description("Document of the SysBaP API of access for endpoints with Swagger")
				.termsOfServiceUrl("")
                .contact(new Contact("Madson Silva", "", "maddytec@gmail.com"))
                .license("Maddytec License Version 1.0")
                .licenseUrl("https://www.maddytec.com.br")
                .version("1.0.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("authkey", "Authorization", "header");
      }
}
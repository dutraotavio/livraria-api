
package br.com.otavio.livraria.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxSwaggerConfigurations {

          @Bean
          public Docket api() {
                    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                                        .paths(PathSelectors.any()).build().apiInfo(apiInfo());
          }

          private ApiInfo apiInfo() {
                    return new ApiInfo("API Livraria", "Teste", "Termos de Uso", "Termos de Servicos",
                                        new Contact("Otávio Dutra", "https://github.com/dutraotavio",
                                                            "dutra.otavio@gmail.com"),
                                        "License of API", "API license URL", Collections.emptyList());
          }

}
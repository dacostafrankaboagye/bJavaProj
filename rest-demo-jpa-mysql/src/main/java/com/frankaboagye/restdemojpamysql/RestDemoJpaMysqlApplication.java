package com.frankaboagye.restdemojpamysql;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import jdk.javadoc.doclet.Doclet;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RestDemoJpaMysqlApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestDemoJpaMysqlApplication.class, args);
	}



	@Bean
	public OpenAPI cloudVendorAPI() {
		return new OpenAPI().info(new Info().title("Frank's Cloud Vendor API")
											.description("Documentation for - Cloud Vendor")
											.version("v0.0.1")
											.license(new License().name("frankLINC").url("http://frankaboagyeLicence.com"))
		);
	}


}

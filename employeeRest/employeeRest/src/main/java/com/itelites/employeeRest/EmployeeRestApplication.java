package com.itelites.employeeRest;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.Properties;
//@EnableSwagger2
@SpringBootApplication
@Configuration
public class EmployeeRestApplication {
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(EmployeeRestApplication.class, args);
//		FileReader reader=new FileReader("db.properties");
//
//		Properties p=new Properties();
//		p.load(reader);
//
//			URL st = (URL)p.getProperty("spring.data.mongodb.uri");
//		HttpUrlConnection conn = (HttpURLConnection) st.openConnection();
//
////set the timeout in milliseconds
//		conn.setConnectTimeout(7000);

	}
//
	@Bean
	public OpenAPI employeeRestOpenApi(){
		return new OpenAPI().info(new Info().title("employee rest application").description(""));
	}



}

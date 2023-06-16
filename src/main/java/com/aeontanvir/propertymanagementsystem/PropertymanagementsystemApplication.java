package com.aeontanvir.propertymanagementsystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Property Management System Endpoints",
				version = "1.0.0",
				contact = @Contact(
						name = "Md Tanvir Rahman Khan",
						email = "aeontanvir@gmail.com"
				)
		)
)
public class PropertymanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertymanagementsystemApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


}

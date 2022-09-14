package com.rajnayan.belong.telephonenumberservice;

import com.rajnayan.belong.telephonenumberservice.impl.NumberServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TelephoneNumberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelephoneNumberServiceApplication.class, args);
	}


	@Bean
	public NumberServiceImpl getNumberService(){
		return new NumberServiceImpl();
	}

}

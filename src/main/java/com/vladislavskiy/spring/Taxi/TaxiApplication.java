package com.vladislavskiy.spring.Taxi;

import com.vladislavskiy.spring.Taxi.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiApplication.class, args);
		System.out.println("ok");
	}

}

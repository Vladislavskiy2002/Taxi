package com.vladislavskiy.spring.Taxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;




@SpringBootApplication
public class TaxiApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaxiApplication.class, args);
		//TODO: забери потом оце
		System.out.println("ok");
	}

}

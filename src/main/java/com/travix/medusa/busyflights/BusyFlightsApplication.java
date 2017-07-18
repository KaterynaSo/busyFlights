package com.travix.medusa.busyflights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@EntityScan
@SpringBootApplication
public class BusyFlightsApplication {

	//the test link is case of runnub on the port 8080 is :
	//http://localhost:8080/busy-flights/getAll?origin=AMS&destination=LHR&departureDate=2017-07-17&returnDate=2017-07-18&numberOfPassengers=1
	public static void main(String[] args) {
		SpringApplication.run(BusyFlightsApplication.class, args);
	}
}

package com.cg.flightsearchapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.cg.flightsearchapi.entity.Flights;
import com.cg.flightsearchapi.repository.FlightRepository;


@SpringBootApplication
@EnableEurekaClient
public class FlightSearchApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSearchApiApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner demoData(FlightRepository repo) {
        return args -> { 

            repo.save(new Flights("1", "GOAIR A36","BBS", "MUM", "03-02-2021", 6000));
            repo.save(new Flights("2", "GOAIR A57","BBS", "MUM", "25-05-2021", 4000));
            repo.save(new Flights("3", "INDIGO B415", "KOL", "BLR", "15-01-201", 7000));
            repo.save(new Flights("4", "AIRINDIA A98", "KOL", "BLR", "15-06-201", 10000));
            repo.save(new Flights("5", "AirAsia India V456", "KOL", "BLR", "22-03-201", 6000));
            repo.save(new Flights("6", "SpiceJet H567","BBS", "MUM", "14-07-2021", 6000));
            repo.save(new Flights("7", "SpiceJet A90","BBS", "MUM", "25-05-2021", 9000));
            repo.save(new Flights("8", "INDIGO B57","BBS", "MUM", "25-05-2021", 9000));
        };
    }

}

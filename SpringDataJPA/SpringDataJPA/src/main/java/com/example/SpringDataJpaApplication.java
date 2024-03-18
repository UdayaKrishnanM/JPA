package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entity.Actor;
import com.example.entity.Movie;
import com.example.service.TheaterService;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(TheaterService service) {
        return (args) -> {
            try {
                // create actor objects
                Actor actor1 = new Actor("Daniel Radcliffe");
                Actor actor2 = new Actor("Rupert Grint");

                // create movie object and add actor for that movie
                Movie avengers = new Movie("Harry Potter 1");
                avengers.addActor(actor1);
                avengers.addActor(actor2);

                // create movie object and add actor for that movie
                Movie infinityWar = new Movie("Harry Potter 2");
                infinityWar.addActor(actor1);
                infinityWar.addActor(actor2);

                service.saveMovie(avengers);
                service.saveMovie(infinityWar);
            } catch (Exception e) {
               e.printStackTrace();
            }
        };
    }
}

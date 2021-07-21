package com.dennis.revolution_test;

import com.dennis.revolution_test.Models.Player;
import com.dennis.revolution_test.Repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RevolutionTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RevolutionTestApplication.class, args);

    }
    @Bean
    public CommandLineRunner start(PlayerRepository playerRepository){
        return args ->playerRepository.save(new Player(5000));
    }
}

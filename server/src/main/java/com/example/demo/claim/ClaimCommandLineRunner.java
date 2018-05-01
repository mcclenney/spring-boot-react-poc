package com.example.demo.claim;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Stream;

@Component
public class ClaimCommandLineRunner implements CommandLineRunner {
    private final ClaimRepository repository;

    public ClaimCommandLineRunner(ClaimRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Alice", "Bob", "John", "Jane").forEach(name ->
            repository.save(new Claim(name, getRandomAmount()))
        );

        repository.findAll().forEach(System.out::println);
    }

    private double getRandomAmount() {
        Random random = new Random();
        return Math.round(1 + (500 - 1) * random.nextDouble() * 100.0) / 100.0;
    }
}

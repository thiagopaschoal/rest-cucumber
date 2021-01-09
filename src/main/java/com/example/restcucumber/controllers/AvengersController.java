package com.example.restcucumber.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/avengers")
public class AvengersController {

    private List<String> avengers = List.of("iron man", "captain america", "thor", "hulk", "hawkeye", "black widow");

    @GetMapping
    public ResponseEntity<List<String>> findAll() {
        return new ResponseEntity<>(avengers, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> findByName(@PathVariable String name) {
        final String avenger = avengers.stream()
                .filter(avengerName -> avengerName.equalsIgnoreCase(name))
                .findFirst()
                .get();
        return new ResponseEntity<>(avenger, HttpStatus.OK);
    }

}

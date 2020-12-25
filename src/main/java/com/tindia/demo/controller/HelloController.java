package com.tindia.demo.controller;


import com.tindia.demo.model.Destination;
import com.tindia.demo.model.Movies;
import com.tindia.demo.model.Greeting;
import com.tindia.demo.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    @Autowired
    DestinationRepository destinationRepository;

    private static final String template = "Hello new, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("Got a new connection ....");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @GetMapping("/bundle")
    public String greeting1(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "THis is bundlew";
    }


    @GetMapping("/films")
    public List<Movies> film(@RequestParam(value = "name", defaultValue = "World") String name) {
        List list = new ArrayList<Movies>();

        Movies f1 = Movies.builder().id(1).description("des").title("sholay").director("sippy").build();
        Movies f2 = Movies.builder().id(2).description("des").title("sholay1").director("sippy").build();
        Movies f3 = Movies.builder().id(3).description("des").title("sholay2").director("sippy").build();
        Movies f4 = Movies.builder().id(4).description("des").title("sholay3").director("sippy").build();
        Movies f5 = Movies.builder().id(5).description("des new").title("tere naam").director(" salman khan").build();

        list.add(f1);
        list.add(f2);
        list.add(f3);
        list.add(f4);
        list.add(f5);
        return list;
    }

    @GetMapping("/destination")
    public List<Destination> showDestination(){
        return destinationRepository.findAll();
    }
}

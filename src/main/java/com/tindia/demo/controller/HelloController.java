package com.tindia.demo.controller;


import com.tindia.demo.model.Film;
import com.tindia.demo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private static final String template = "Hello, %s!";
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
    public List<Film> film(@RequestParam(value = "name", defaultValue = "World") String name) {
        List list = new ArrayList<Film>();

        Film f1 = Film.builder().id(1).description("des").title("sholay").director("sippy").build();
        Film f2 = Film.builder().id(2).description("des").title("sholay1").director("sippy").build();
        Film f3 = Film.builder().id(3).description("des").title("sholay2").director("sippy").build();
        Film f4 = Film.builder().id(4).description("des").title("sholay3").director("sippy").build();

        list.add(f1);
        list.add(f2);
        list.add(f3);
        list.add(f4);
        return list;
    }
}

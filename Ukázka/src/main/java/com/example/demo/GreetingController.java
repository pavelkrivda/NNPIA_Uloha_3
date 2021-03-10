package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

@Controller
@RequestMapping("user")				// vše bude ve tvaru např:	localhost:8080/user/greeting
public class GreetingController{

    private final CounterService counterService;

    public GreetingController(@Qualifier("counterServiceImpl") CounterService counterService) {
        this.counterService = counterService;
    }


    // Bude reagovat jak na POST tak GET
    @RequestMapping(value = "/greeting", method = {RequestMethod.GET , RequestMethod.POST})
    public String requestGreeting(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model){

        counterService.add();
        model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
        model.addAttribute("counter", counterService.getCounter());
        return  "greeting";
    }

    // Bude reagovat pouze na GET požadavek
    // localhost:8080/welcome/name=pepa
    @GetMapping(value = "/greetingget")
    public String requestGreetingGet(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model){

        counterService.add();
        model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
        model.addAttribute("counter", counterService.getCounter());
        return  "greeting";
    }

    // Bude reagovat pouze na POST požadavek
    @PostMapping(value = "/greetingpost")
    public String requestGreetingPost(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model){

        counterService.add();
        model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
        model.addAttribute("counter", counterService.getCounter());
        return  "greeting";
    }

    // Bude reagovat pouze na GET požadavek, parametr stačí napsat ve tvaru
    // localhost:8080/welcome/pepa
    @RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
    public String requestWelcome(@PathVariable(name="name", required = false) String name, Model model){

        counterService.add();
        model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
        model.addAttribute("counter", counterService.getCounter());
        return  "greeting";
    }
}
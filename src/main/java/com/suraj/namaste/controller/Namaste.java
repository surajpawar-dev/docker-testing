package com.suraj.namaste.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Namaste {

    @GetMapping("/namaste")
    public String namaste() {
        System.out.println("Namaste project is running here....");
        return "Namaste, World!";
    }
}

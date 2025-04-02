package com.suraj.namaste.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Namaste {

    @GetMapping("/namaste")
    public String namaste() {
        return "Namaste, World!";
    }
}

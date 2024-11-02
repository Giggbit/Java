package com.example.demo.controller;

import com.example.demo.aspect.VisitCounterAspect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final VisitCounterAspect visitCounterAspect;

    public MainController(VisitCounterAspect visitCounterAspect) {
        this.visitCounterAspect = visitCounterAspect;
    }

    @GetMapping("/main")
    public String mainPage() {
        return "Главная страница - Количество посещений: " + visitCounterAspect.getMainPageVisits();
    }
}


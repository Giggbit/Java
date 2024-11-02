package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VisitCounterAspect {

    private int mainPageVisits = 0;
    private int adminPageVisits = 0;

    @After("execution(* com.example.demo.controller.MainController.mainPage(..))")
    public void countMainPageVisit() {
        mainPageVisits++;
        System.out.println("Количество посещений главной страницы: " + mainPageVisits);
    }

    @After("execution(* com.example.demo.controller.AdminController.adminPage(..))")
    public void countAdminPageVisit() {
        adminPageVisits++;
        System.out.println("Количество посещений админки: " + adminPageVisits);
    }

    // Геттеры для счетчиков
    public int getMainPageVisits() {
        return mainPageVisits;
    }

    public int getAdminPageVisits() {
        return adminPageVisits;
    }
}

package com.yasmeen.cinema.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YasmeenHj
 * created on 9/22/2022 at 3:03 PM
 * @project CinemaApp
 */
@RestController
@RequestMapping("api")
@Profile("qa")
public class MyController {
    @GetMapping
    public String test() {
        return "Hi My Controller ";
    }
}

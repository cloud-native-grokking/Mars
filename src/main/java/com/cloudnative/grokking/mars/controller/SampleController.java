package com.cloudnative.grokking.mars.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ping")
public class SampleController {

    @GetMapping
    @PostMapping
    public String ping() {
        return "pong";
    }
}
package com.example.tiviaavaliacao.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/")
public class BeneficiarioController {


    @GetMapping
    public String greeting() {
        return "Hello, World!";
    }
}
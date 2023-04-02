package com.xfactor.openlibrary.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;

@RestController

// @RequestMapping("helloController")  // maps this page with a particular path. 
                                       // If any other class is present in this file then another mapping can be done

public class Hello {

    /* 
        PathVariable uses /
        RequestParam uses ?
    */

    /* 1 PathVariable */
    // http://localhost:8080/greet/Good%20Morning
    @GetMapping("/greet/{msg}")
    public String greet(@PathVariable String msg) {
        return "Hello " + msg;
    }

    /* 1 RequestParam */
    // http://localhost:8080/hi?age=21
    @GetMapping("/hi")
    public String age(@RequestParam int age) {
        return "Your age is: " + age;
    }

    /* 1 PathVariable anf 1 RequestParam */
    // http://localhost:8080/hello/Spring?age=1234
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name, @RequestParam String age) {
        return "Hello " + name + " Age " + age;
    }

    /* 2 RequestParam */
    // http://localhost:8080/spring?name=Spring&age=1234
    @GetMapping("/spring")
    public String spring(@RequestParam String name, @RequestParam int age) {
        return "Hello! My name is " + name + " and my age is " + age; 
    }

    /* 2 PathVariable */
    // http://localhost:8080/clg/Spring/1234
    @GetMapping("/clg/{name}/{age}")
    public String clg(@PathVariable String name, @PathVariable int age) {
        return "Hello! My name is " + name + " and my age is " + age; 
    }

    // // Not allowed - PathVariable should come before the RequestParam
    /*
    @GetMapping("/fk/{name}/{clgName}")
    public String fk(@PathVariable String name, @RequestParam int age, @PathVariable String clgName) {
         
        return "Hello! My name is " + name + " and my age is " + age + ". Study in " + clgName; 
    }*/
    

    // http://localhost:8080/clg/Spring/1234
    @GetMapping("/fn/{name}/{age}")
    public HashMap<String,String> xyz(@PathVariable String name, @PathVariable int age) {
        // Here both name and age are used as String so both String are given in Hashmap parameters
        HashMap<String,String> sd = new HashMap<>();
        sd.put("name" , name);
        sd.put("age", String.valueOf(age));

        return sd;
    }

    // http://localhost:8080/clg/Spring/1234
    @GetMapping("/fnw/{name}/{age}")
    public HashMap<String,Object> wxyz(@PathVariable String name, @PathVariable int age) {
        // Here name is used as String and age is used as Integer so in Hashmap parameters String is used for name and Object is used for age. 
        // Integer cannot be used for age because name also exists as String, so we have to use Object.
        // But we can use Object for both.
        HashMap<String,Object> sd = new HashMap<>();
        sd.put("name" , name);
        sd.put("age", age);

        return sd;
    }
}
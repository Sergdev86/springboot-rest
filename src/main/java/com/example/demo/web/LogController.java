package com.example.demo.web;

import com.example.demo.model.Statistic;
import com.example.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogController {

    @Autowired
    private LogService service;

    @GetMapping(value = "/api/search", params = "q")
    public Statistic getLogs(@RequestParam("q") String q){
        return service.getStatistic(q);
    }
}

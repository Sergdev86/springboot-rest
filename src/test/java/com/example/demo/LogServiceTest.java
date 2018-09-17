package com.example.demo;

import com.example.demo.model.Statistic;
import com.example.demo.service.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class LogServiceTest {

    @Resource
    private LogService service;

    @Test
    public void testGetStatistic(){

        Statistic statistic = service.getStatistic("error");

        String resultLog = statistic.getResults().get(0).getLogLine();

        String log = "1 log error";

        assertEquals(log, resultLog);

        int indexResult = statistic.getResults().get(0).getLinenumber();

        assertEquals(1, indexResult);

    }
}

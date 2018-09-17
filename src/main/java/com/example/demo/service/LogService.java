package com.example.demo.service;

import com.example.demo.model.LogData;
import com.example.demo.model.Statistic;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LogService {

    private String fileResource = "C:\\log.txt";

    public Statistic getStatistic(String restParam){

        ArrayList<String> lines = (ArrayList<String>) getAllLogs();

        int linenumber = 0;

        //  lines with matching query
        List<LogData> results = new ArrayList<>();

        for (String value : lines) {
            linenumber++;
            if(value.toLowerCase().contains(restParam.toLowerCase())) {
                results.add(new LogData(linenumber, value));
            }
        }

        //  main object that includes result(logs list) and number of logs
        Statistic statistic = new Statistic(results, results.size());

        return statistic;
    }


    private List<String> getAllLogs(){

        List<String> lines = new ArrayList<>();

        //  getting Stream of lines from log.txt and converting it to ArrayList
        try (Stream<String> text = Files.lines(Paths.get(fileResource))) {

            lines = text.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
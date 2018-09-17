package com.example.demo.service;

import com.example.demo.model.LogData;
import com.example.demo.model.Statistic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LogService {

    private static ResourceBundle props = ResourceBundle.getBundle("application");
    private String fileResource = props.getString("file.location");

    public Statistic getStatistic(String restParam){

        ArrayList<String> lines;

        try{

            lines = getAllLogs();

        }catch (IOException e){
            lines = new ArrayList<>();
            lines.add("Log file not found!");
            ArrayList<LogData> resErr = new ArrayList<>();
            resErr.add(new LogData(1, lines.get(0)));
            return new Statistic(resErr, resErr.size());
        }


        int linenumber = 0;

        //  lines with matching query
        ArrayList<LogData> results = new ArrayList<>();

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


    private ArrayList<String> getAllLogs()throws IOException{

        ArrayList<String> lines;

        //  getting Stream of lines from log.txt and converting it to ArrayList
        try (Stream<String> text = Files.lines(Paths.get(fileResource))) {

            lines = text.collect(Collectors.toCollection(ArrayList::new));

        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
        return lines;
    }

}
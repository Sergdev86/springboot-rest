package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class LogData {

    private int linenumber;
    private String value;

    public LogData(){}

    public LogData(int linenumber, String value) {
        this.linenumber = linenumber;
        this.value = value;
    }

    public int getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(int linenumber) {
        this.linenumber = linenumber;
    }

    public String getLogLine() {
        return value;
    }

    public void setLogLine(String logLine) {
        this.value = logLine;
    }
}

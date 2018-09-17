package com.example.demo.model;

import java.util.List;

/**
 * Created by Сергей on 16.09.2018.
 */
public class Statistic {

    private List<LogData> results;
    private int count;

    public Statistic() {}

    public Statistic(List<LogData> results, int count) {
        this.results = results;
        this.count = count;
    }

    public List<LogData> getResults() {
        return results;
    }

    public void setResults(List<LogData> results) {
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

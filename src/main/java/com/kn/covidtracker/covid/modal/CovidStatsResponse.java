package com.kn.covidtracker.covid.modal;

public class CovidStatsResponse {

    public int confirmed;
    public int recovered;
    public int deaths;
    public int new_confirmed;
    public int new_deaths;
    public double vaccination_level;

    @Override
    public String toString() {
        return "CovidStatsResponse{" +
                "confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", new_confirmed=" + new_confirmed +
                ", new_deaths=" + new_deaths +
                ", vaccination_level=" + vaccination_level +
                '}';
    }
}

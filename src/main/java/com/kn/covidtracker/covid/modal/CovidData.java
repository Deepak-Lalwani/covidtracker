package com.kn.covidtracker.covid.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

public class CovidData implements Serializable {

    @Serial
    private static final long serialVersionUID = 8156526077883281628L;

    public int confirmed;
    public int recovered;
    public int deaths;
    public String country;
    public int population;
    public int sq_km_area;
    public String life_expectancy;
    public int elevation_in_meters;
    public String continent;
    public String abbreviation;
    public String location;
    public int iso;
    public String capital_city;
    public String lat;
    @JsonProperty("long")
    public String mylong;
    public String updated;

    @Override
    public String toString() {
        return "CovidData{" +
                "confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", sq_km_area=" + sq_km_area +
                ", life_expectancy='" + life_expectancy + '\'' +
                ", elevation_in_meters=" + elevation_in_meters +
                ", continent='" + continent + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", location='" + location + '\'' +
                ", iso=" + iso +
                ", capital_city='" + capital_city + '\'' +
                ", lat='" + lat + '\'' +
                ", mylong='" + mylong + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}

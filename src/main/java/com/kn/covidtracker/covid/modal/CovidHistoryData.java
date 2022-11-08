package com.kn.covidtracker.covid.modal;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashMap;

public class CovidHistoryData implements Serializable {

        @Serial
        private static final long serialVersionUID = 8266726077883281622L;

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
        public LinkedHashMap<String, Integer> dates;

        @JsonAnySetter
        void setDates(String key, Integer value) {
                dates.put(key, value);
        }

        @Override
        public String toString() {
                return "CovidHistoryData{" +
                        "country='" + country + '\'' +
                        ", population=" + population +
                        ", sq_km_area=" + sq_km_area +
                        ", life_expectancy='" + life_expectancy + '\'' +
                        ", elevation_in_meters=" + elevation_in_meters +
                        ", continent='" + continent + '\'' +
                        ", abbreviation='" + abbreviation + '\'' +
                        ", location='" + location + '\'' +
                        ", iso=" + iso +
                        ", capital_city='" + capital_city + '\'' +
                        ", dates=" + dates +
                        '}';
        }
}

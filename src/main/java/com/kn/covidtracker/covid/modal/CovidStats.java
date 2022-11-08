package com.kn.covidtracker.covid.modal;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class CovidStats implements Serializable {

    @Serial
    private static final long serialVersionUID = 7156526077883281623L;

    @JsonProperty("All")
    public CovidData covidData;

    Map<String, Object> otherData = new LinkedHashMap<>();

    @JsonAnySetter
    void setOtherData(String key, Object value) {
        otherData.put(key, value);
    }

    @Override
    public String toString() {
        return "CovidStats{" +
                "covidData=" + covidData +
                ", otherData=" + otherData +
                '}';
    }

}

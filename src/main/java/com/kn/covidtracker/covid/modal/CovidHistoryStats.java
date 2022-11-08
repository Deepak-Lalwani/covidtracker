package com.kn.covidtracker.covid.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

public class CovidHistoryStats implements Serializable {

    @Serial
    private static final long serialVersionUID = 9156526077883281629L;

    @JsonProperty("All")
    public CovidHistoryData covidHistoryData;

    @Override
    public String toString() {
        return "CovidHistoryStats{" +
                "covidHistoryData=" + covidHistoryData +
                '}';
    }
}

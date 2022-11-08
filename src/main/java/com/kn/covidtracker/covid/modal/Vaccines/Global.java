package com.kn.covidtracker.covid.modal.Vaccines;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

public class Global implements Serializable {

    @Serial
    private static final long serialVersionUID = 8156526077883281627L;

    @JsonProperty("All")
    public VaccinesData vaccinesData;

    @Override
    public String toString() {
        return "Global{" +
                "vaccinesData=" + vaccinesData +
                '}';
    }
}

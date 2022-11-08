package com.kn.covidtracker.covid.modal.Vaccines;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kn.covidtracker.covid.modal.Vaccines.Global;

import java.io.Serial;
import java.io.Serializable;

public class VaccinesStats implements Serializable {

    @Serial
    private static final long serialVersionUID = 8156526077883281625L;

    @JsonProperty("Global")
    public Global global;

    @Override
    public String toString() {
        return "VaccinesStats{" +
                "global=" + global +
                '}';
    }
}

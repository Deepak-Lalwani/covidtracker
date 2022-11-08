package com.kn.covidtracker.covid.service;

import com.kn.covidtracker.covid.modal.CovidHistoryStats;
import com.kn.covidtracker.covid.modal.CovidStats;
import com.kn.covidtracker.covid.modal.CovidStatsResponse;
import com.kn.covidtracker.covid.modal.Vaccines.VaccinesStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidStatsResponseService {

    @Autowired
    private CovidStatsService covidStatsService;

    public CovidStatsResponse getCovidStats(String country) {
        CovidStats liveCovidStats = covidStatsService.getCovidLiveStats(country);
        CovidHistoryStats confirmedCovidHistoryStats = covidStatsService.getConfirmedCovidHistoryStats(country);
        CovidHistoryStats deathsCovidHistoryStats = covidStatsService.getDeathsCovidHistoryStats(country);
        VaccinesStats vaccinesStats = covidStatsService.getVaccinesStats(country);

        CovidStatsResponse covidStatsResponse = new CovidStatsResponse();

        covidStatsResponse.confirmed = liveCovidStats.covidData.confirmed;
        covidStatsResponse.recovered = liveCovidStats.covidData.recovered;
        covidStatsResponse.deaths = liveCovidStats.covidData.deaths;

        int lastConfirmedStats = confirmedCovidHistoryStats.covidHistoryData.dates.entrySet().iterator().next().getValue();
        int lastDeathStats = deathsCovidHistoryStats.covidHistoryData.dates.entrySet().iterator().next().getValue();

        covidStatsResponse.new_confirmed = liveCovidStats.covidData.confirmed - lastConfirmedStats;
        covidStatsResponse.new_deaths = liveCovidStats.covidData.deaths - lastDeathStats;

        covidStatsResponse.vaccination_level = (vaccinesStats.global.vaccinesData.people_vaccinated  * 100) / vaccinesStats.global.vaccinesData.population;

//        System.out.println("CovidHistoryStats " + covidStatsResponse.toString() );
        return covidStatsResponse;
    }
}

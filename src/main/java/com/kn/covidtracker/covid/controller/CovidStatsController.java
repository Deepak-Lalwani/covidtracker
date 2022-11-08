package com.kn.covidtracker.covid.controller;

import com.kn.covidtracker.covid.modal.*;
import com.kn.covidtracker.covid.modal.Vaccines.VaccinesStats;
import com.kn.covidtracker.covid.service.CovidStatsResponseService;
import com.kn.covidtracker.covid.service.CovidStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid/stats")
public class CovidStatsController {

    @Autowired
    private CovidStatsService covidStatsService;

    @Autowired
    private CovidStatsResponseService covidStatsResponseService;

    @GetMapping("")
    public CovidStatsResponse getCovidStats(@RequestParam String country) {
        CovidStatsResponse covidStats = covidStatsResponseService.getCovidStats(country);
        System.out.println("Covid Stats" + covidStats.toString() );
        return covidStats;
    }

    @GetMapping("/live")
    public CovidStats getCovidLiveStats(@RequestParam String country) {
        CovidStats covidStats = covidStatsService.getCovidLiveStats(country);
        System.out.println("Covid Live Stats" + covidStats.toString() );
        return covidStats;
    }

    @GetMapping("/history")
    public CovidHistoryStats getConfirmedCovidHistoryStats(@RequestParam String country, @RequestParam String status) {
        CovidHistoryStats covidHistoryStats = null;
        if(status.equals("Confirmed")){
            covidHistoryStats = covidStatsService.getConfirmedCovidHistoryStats(country);
        } else if(status.equals("Deaths")){
            covidHistoryStats = covidStatsService.getDeathsCovidHistoryStats(country);
        }
        System.out.println("Covid History Stats" + covidHistoryStats.covidHistoryData.dates.entrySet().iterator().next());
        return covidHistoryStats;
    }

    @GetMapping("/vaccines")
    public VaccinesStats getVaccinesStats(@RequestParam String country) {
        VaccinesStats vaccinesStats = covidStatsService.getVaccinesStats(country);
        System.out.println("Vaccine Stats" + vaccinesStats.toString() );
        return vaccinesStats;
    }

}

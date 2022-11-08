package com.kn.covidtracker.covid.service;

import com.kn.covidtracker.covid.modal.CovidHistoryStats;
import com.kn.covidtracker.covid.modal.CovidStats;
import com.kn.covidtracker.covid.modal.Vaccines.VaccinesStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CovidStatsService {

    //private static final Logger log = LoggerFactory.getLogger(CovidStatsService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Cacheable(key="#country", value = "covidLiveCache")
    public CovidStats getCovidLiveStats(String country) {
        CovidStats covidStats = restTemplate.getForObject(
                "https://covid-api.mmediagroup.fr/v1/cases?country="+country, CovidStats.class);
//        System.out.println("Covid Stats" + covidStats.toString() );
        System.out.println("getCovidLiveStats called");
        return covidStats;
    }

    @Cacheable(key="#country", value = "covidConfirmedHistoryCache")
    public CovidHistoryStats getConfirmedCovidHistoryStats(String country) {
        CovidHistoryStats covidHistoryStats = restTemplate.getForObject(
					"https://covid-api.mmediagroup.fr/v1/history?country="+country+"&status=Confirmed", CovidHistoryStats.class);
//        System.out.println("Covid confirmed Stats" + covidHistoryStats.toString() );
        System.out.println("getConfirmedCovidHistoryStats called");
        return covidHistoryStats;
    }

    @Cacheable(key="#country", value = "covidDeathsHistoryCache")
    public CovidHistoryStats getDeathsCovidHistoryStats(String country) {
        CovidHistoryStats covidHistoryStats = restTemplate.getForObject(
                "https://covid-api.mmediagroup.fr/v1/history?country="+country+"&status=Deaths", CovidHistoryStats.class);

//        System.out.println("Covid detahs Stats" + covidHistoryStats.toString() );
        System.out.println("getDeathsCovidHistoryStats called");
        return covidHistoryStats;
    }

    @Cacheable(key="#country", value = "vaccineCache")
    public VaccinesStats getVaccinesStats(String country) {
        VaccinesStats vaccinesStats = restTemplate.getForObject(
                "https://covid-api.mmediagroup.fr/v1/vaccines?country="+country, VaccinesStats.class);
//        System.out.println("vaccines Stats" + vaccinesStats.toString() );
        System.out.println("getVaccinesStats called");
        return vaccinesStats;
    }

}

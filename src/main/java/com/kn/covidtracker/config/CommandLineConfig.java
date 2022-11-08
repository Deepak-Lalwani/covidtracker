package com.kn.covidtracker.config;

import com.kn.covidtracker.covid.modal.CovidStatsResponse;
import com.kn.covidtracker.covid.service.CovidStatsResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLineConfig implements CommandLineRunner {

    public static String country = "";

    @Autowired
    CovidStatsResponseService covidStatsResponseService;

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Covid Tracker");
        System.out.println("Please provide Country Name : ");
        country = scanner.nextLine();
        System.out.println("Your Entered Country : "+ country);
        System.out.println("Please wait while we fetch results for you...");
        CovidStatsResponse covidStatsResponse = covidStatsResponseService.getCovidStats(country);
        System.out.println("Here are the Covid related stats : " + covidStatsResponse);

        System.out.println("Would you like to continue with another country ? y/n: ");
        String choice = scanner.nextLine();
        if(choice.equals("y") || choice.equalsIgnoreCase("YES")) run(args);
        else System.exit(SpringApplication.exit(context, (ExitCodeGenerator) () -> 0));
    }
}

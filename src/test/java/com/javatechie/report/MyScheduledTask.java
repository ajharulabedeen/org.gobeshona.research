package com.javatechie.report;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledTask {

    // This method will be executed every minute
    @Scheduled(cron = "0 * * * * ?")
    public void runTask() {
        // Define the task you want to perform here
        System.out.println("Scheduled task is Every Minute: ");
    }
}

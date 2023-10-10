package com.javatechie.report.thread;

import com.javatechie.report.entity.DataSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    DataSharing dataSharing;

    @GetMapping("/task")
    public String task(@RequestParam(required = false) String threadName) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Random random = new Random();
        int randomNumber = (random.nextInt(9) + 2);
        long startTime = System.currentTimeMillis();

        Thread taskThread = new Thread(() -> {
            if (threadName != null) {
                Thread.currentThread().setName(threadName);
            }
            System.out.println("Hello, World!");
            int count = 0;
            try {
                System.out.println("start:");
                for (int i = 0; i < randomNumber; i++) {
                    System.out.print(i + 1);
                    Thread.sleep(1000);
                    count++;
                }
                dataSharing.setData("count : " + count);
                System.out.println("end: " + dataSharing.getData());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            completableFuture.complete("Task completed in : " + elapsedTime + " -- " + threadName); // Complete the CompletableFuture when done
        });
        taskThread.start();

        try {
            return completableFuture.get(); // Wait for the task to complete and return the result
        } catch (Exception e) {
            return "Task failed : " + e.getMessage();
        }
    }
}


//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class TaskController {
//
//    @GetMapping("/task")
//    public String task(@RequestParam(required = false) String threadName) {
//        Thread taskThread = new Thread(() -> {
//            if (threadName != null) {
//                Thread.currentThread().setName(threadName);
//            }
//
//            try {
//                System.out.println("started: Hello, World!");
//                for (int i = 0; i < 10; i++) {
//                    Thread.sleep(1000);
//                    System.out.println(i);
//                }
//                System.out.println("ended: Hello, World!");
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        });
//        taskThread.start();
//        return "Task started in a separate thread.";
//    }
//}
//

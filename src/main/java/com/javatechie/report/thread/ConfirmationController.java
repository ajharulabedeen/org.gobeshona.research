package com.javatechie.report.thread;

import com.javatechie.report.entity.DataSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConfirmationController {

    @Autowired
    DataSharing dataSharing;

    @GetMapping("/confirmation")
    public String confirmation(@RequestParam(required = false) String threadName) {
        System.out.println(" \n Confirmattion call : " + threadName);
        Thread taskThread = findThreadByName(threadName);
        if (taskThread != null) {
            try {
//                taskThread.join(2000); // Wait for up to 3 seconds for the task thread to complete
                taskThread.join(); // Wait for up to 3 seconds for the task thread to complete
                if (!taskThread.isAlive()) {
                    System.out.println("Completed! : " + threadName);
                    return "Completed : " + threadName + "Data Share : " + dataSharing.getData();
                } else {
                    return "TIME OUT : " + threadName;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return "Task not found";
    }

    private Thread findThreadByName(String name) {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        while (currentGroup.getParent() != null) {
            currentGroup = currentGroup.getParent();
        }
        Thread[] threads = new Thread[currentGroup.activeCount()];
        currentGroup.enumerate(threads);
        for (Thread thread : threads) {
            if (thread.getName().equals(name)) {
                return thread;
            }
        }
        return null;
    }
}

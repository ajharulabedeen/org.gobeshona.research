package com.javatechie.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @GetMapping("/show-report")
    public String showReportPage() {
        return "report";
    }
}

package com.javatechie.report;

import com.javatechie.report.repository.BengaliEntryRepository;
import com.javatechie.report.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootJasperReportApplicationTests {

    @Autowired
    BengaliEntryRepository repository;

    @Autowired
    ReportService reportService;


    @Test
    void contextLoads() {
        System.out.println("reportService = " + reportService);
//        repository.findAll().forEach(bengaliEntry -> System.out.println("bengaliEntry = " + bengaliEntry));
    }

    @Test
    void testCustomRepo() {

    }

}

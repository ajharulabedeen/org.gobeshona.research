package com.javatechie.report;

import com.javatechie.report.entity.Employee;
import com.javatechie.report.repository.EmployeeRepository;
import com.javatechie.report.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.javatechie.report.service.ReportService.readTableContents;

@SpringBootApplication
@RestController
public class SpringBootJasperReportApplication {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private ReportService service;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {

        return repository.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReport(format);
    }

    @GetMapping("/report-ific/{format}/{size}")
    public String generateReportIFIC(@PathVariable String format, @PathVariable Integer size) throws FileNotFoundException, JRException {
        return service.generateNoticeLetterJasper(format, size);
    }

    @GetMapping("/download-report")
    public ResponseEntity<byte[]> downloadReport() throws IOException {
        // Path to the generated PDF file
//        String pdfFilePath = "src/main/resources/output/report.pdf";
        String pdfFilePath = "report.pdf";

        Path pdfPath = Paths.get(pdfFilePath);
        byte[] pdfBytes = Files.readAllBytes(pdfPath);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

    @GetMapping("/html")
    public String purseString() throws IOException {
        return service.purseTheReport();
    }


    @GetMapping("/fetch-report")
    @ResponseBody
    public String fetchReport() {
        return service.purseTheReport();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJasperReportApplication.class, args);
    }

}

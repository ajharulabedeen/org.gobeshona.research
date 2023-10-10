package com.javatechie.report.service;

import com.javatechie.report.entity.AmountDetailsDto;
import com.javatechie.report.entity.Employee;
import com.javatechie.report.entity.NoticeLetterDto;
import com.javatechie.report.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class ReportService {

    @Autowired
    private EmployeeRepository repository;


    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "E:\\projects\\example_code";
//        String path = "/";
        List<Employee> employees = repository.findAll();


        //load file and compile it
        File file = ResourceUtils.getFile("classpath:employees.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
//            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/employees.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
//            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/employees.pdf");
        }

        return "report generated in path : " + path;
    }


    public String generateNoticeLetterJasper(String reportFormat, Integer size) throws FileNotFoundException, JRException {
        NoticeLetterDto noticeLetter = getDummyNoticeLetter();
        String path = "E:\\projects\\example_code";
//        String path = "/";
//        List<Employee> employees = repository.findAll();
        List<AmountDetailsDto> employees = generateRandomAmountDetails(size);
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:notice_letter_1_A4.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);

        NoticeLetterDto noticeLetterDto = getDummyNoticeLetter();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ref_no", noticeLetterDto.getRef_no());
        parameters.put("date", noticeLetterDto.getDate());
        parameters.put("name", noticeLetterDto.getName());
        parameters.put("address", noticeLetterDto.getAddress());
        parameters.put("contact", noticeLetterDto.getContact());
        parameters.put("subject", noticeLetterDto.getSubject());
        parameters.put("loan_acc_no", noticeLetterDto.getLoan_acc_no());
        parameters.put("overdue_amount", noticeLetterDto.getOverdue_amount());
        parameters.put("no_of_due", noticeLetterDto.getNo_of_due());
        parameters.put("branch_name", noticeLetterDto.getBranch_name());
        parameters.put("account_detials", dataSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);


//working
        //        // Save the generated report to the resource folder
        //        String outputPath = "report/report.pdf"; // Output path in resource folder
//
//        // Get the class loader to access resources
//        ClassLoader classLoader = getClass().getClassLoader();
//        File outputFile = new File(classLoader.getResource(outputPath).getFile());
//
//        // Export the report to PDF format
//        JasperExportManager.exportReportToPdfFile(jasperPrint, outputFile.getAbsolutePath());


        // Output directory in resource folder
        File outputDirectory = new File("src/main/resources/output");
        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs();
        }

        // Output PDF file path
//        String outputPath = "src/main/resources/output/report.pdf";
        String outputPath = "report.pdf";

        // Export the report to PDF format and save it
        JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath);

        outputPath = "report.html";
        JasperExportManager.exportReportToHtmlFile(jasperPrint, outputPath);


//working
//        // Save the generated report to the resource folder
//        String outputPath = "/report/report.pdf"; // Output path in resource folder
//        JasperExportManager.exportReportToHtmlFile(jasperPrint, outputPath);
//
//        if (reportFormat.equalsIgnoreCase("html")) {
////            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\notice_letter_1_A4.html");
////            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/employees.html");
//        }
//        if (reportFormat.equalsIgnoreCase("pdf")) {
////            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\notice_letter_1_A4.pdf");
//            JasperExportManager.exportReportToHtmlFile(jasperPrint, outputPath);
////            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/employees.pdf");
//        }

        return "report generated in path : " + outputPath;

    }


    public String purseTheReport() {
        String htmlFilePath = "report.html";
        String tableContents = readTableContents(htmlFilePath);
        System.out.println(tableContents);
        return tableContents;
    }

    public static String readTableContents(String filePath) {
        File input = new File(filePath);
        try {
            Document doc = Jsoup.parse(input, "UTF-8");
            Element table = doc.select("table.jrPage").first();
            if (table != null) {
                return table.outerHtml();
            } else {
                return "Table not found.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred.";
        }
    }

    private NoticeLetterDto getDummyNoticeLetter() {
        NoticeLetterDto noticeLetter = new NoticeLetterDto();
        noticeLetter.setRef_no("REF123");
        noticeLetter.setDate("2023-08-13");
        noticeLetter.setName("John Doe");
        noticeLetter.setAddress("123 Main St, City");
        noticeLetter.setContact("johndoe@example.com");
        noticeLetter.setSubject("Notice of Overdue Payment");
        noticeLetter.setLoan_acc_no("LOAN456");
        noticeLetter.setOverdue_amount("5000 USD");
        noticeLetter.setNo_of_due("3");
        noticeLetter.setBranch_name("City Branch");
        return noticeLetter;
    }

    public static List<AmountDetailsDto> generateRandomAmountDetails(int count) {
        List<AmountDetailsDto> amountDetailsList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i <= count; i++) {
            AmountDetailsDto amount = new AmountDetailsDto();
            amount.setSl_no(String.valueOf(i));
            amount.setProduct_name("Product " + i);
            amount.setLimit(random.nextInt(20000) + 1000 + " USD");
            amount.setOutstanding(random.nextInt(10000) + 500 + " USD");
            amount.setExpiry(getRandomDate());
            amount.setCummulative_unpaid(random.nextInt(4000) + 100 + " USD");
            amountDetailsList.add(amount);
        }

        return amountDetailsList;
    }

    public static String getRandomDate() {
        int year = 2023;
        int month = 1 + (int) (Math.random() * 12);
        int day = 1 + (int) (Math.random() * 28); // Assuming all months have 28 days

        return year + "-" + (month < 10 ? "0" : "") + month + "-" + (day < 10 ? "0" : "") + day;
    }
}

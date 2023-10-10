package com.javatechie.report.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoticeLetterDto {
    private String ref_no;
    private String date;
    private String name;
    private String address;
    private String contact;
    private String subject;
    private String loan_acc_no;
    private String overdue_amount;
    private String no_of_due;
    private String branch_name;
}

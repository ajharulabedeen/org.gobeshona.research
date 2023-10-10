package com.javatechie.report;

import org.junit.jupiter.api.Test;
import com.github.nyholmniklas.arithmetic.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

//@SpringBootTest
class ArithMaticTests {

    @Autowired
    Operation operation;

    @Test
    void contextLoads() {
        int x;
        x=10;
        System.out.println("Operation.add() = " + Operation.add(new BigDecimal("10"),new BigDecimal("12")));
    }

    @Test
    void testCustomRepo() {

    }

}

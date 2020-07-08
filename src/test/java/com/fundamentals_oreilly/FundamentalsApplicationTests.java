package com.fundamentals_oreilly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.text.NumberFormat;

@SpringBootTest
class FundamentalsApplicationTests {
    @Autowired
    private ApplicationContext context;

    @Autowired
    @Qualifier("defaultCurrencyFormat")
    private NumberFormat nf;

    @Test
    public void defaultCurrency() {
        double amount = 1234567.901234;
        System.out.println("The amount in default:" + nf.format(amount));
    }

    @Test
    public void germanyCurrency() {
        double amount = 1234567.901234;
        NumberFormat germany = context.getBean("germanyCurrencyFormat", NumberFormat.class);
        System.out.println("The amount in german:" + germany.format(amount));
    }


    @Test
    void contextLoads() {
        int count = context.getBeanDefinitionCount();
        System.out.printf("The count of beans is %s ", context.getBeanDefinitionCount());
    }

}

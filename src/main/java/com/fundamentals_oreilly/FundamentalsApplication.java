package com.fundamentals_oreilly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.NumberFormat;
import java.util.Locale;

@SpringBootApplication
public class FundamentalsApplication {
    public static void main(String[] args) {
        SpringApplication.run(FundamentalsApplication.class, args);
    }

    @Bean
    public NumberFormat defaultCurrencyFormat() {
        return NumberFormat.getCurrencyInstance();
    }

    @Bean
    NumberFormat germanyCurrencyFormat() {
        return NumberFormat.getCurrencyInstance(Locale.GERMANY);
    }

}



package com.candela.bookingpad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories("com.candela.bookingpad")
@EnableAspectJAutoProxy
@SpringBootApplication
public class BookingpadEntryPoint {
    public static void main(String[] args) {
        SpringApplication.run(BookingpadEntryPoint.class, args);
    }
}

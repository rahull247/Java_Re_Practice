package com.practice.firstms.configuration;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyActualHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        System.out.println("*** Health Indicator ***");

        //Health.down();

        return Health.up()
                .withDetail("orderms", "available")
                .withDetail("paymentms", "available")
                .build();
    }
}

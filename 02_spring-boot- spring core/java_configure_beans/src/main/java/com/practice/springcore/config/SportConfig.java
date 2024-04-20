package com.practice.springcore.config;

import com.practice.springcore.common.Coach;
import com.practice.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
@Bean
    public Coach swimCoach()
{
    return new SwimCoach();
}
}


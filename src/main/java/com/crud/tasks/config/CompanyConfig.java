package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CompanyConfig {
    @Value("${company.name}")
    private String companyName;

    @Value("${company.goal}")
    private String companyGoal;

    @Value("${company.email}")
    private String companyMail;
}

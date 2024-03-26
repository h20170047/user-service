package com.svj;

import com.svj.validation.PaymentValidator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableAutoConfiguration
@EnableConfigurationProperties(value = { PaymentValidator.class})
public class TestApp {}

package com.svj.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PaymentValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PaymentValidation {
    String message() default "Invalid Payment Method";
    Class<?>[] groups() default {};
//    String paymentMethods() default "paymentMethods";
    Class<? extends Payload>[] payload() default {};
}

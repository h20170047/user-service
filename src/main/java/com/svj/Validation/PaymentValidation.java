//package com.svj.Validation;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//
//import java.lang.annotation.*;
//
//@Documented
//@Constraint(
//        validatedBy = PaymentValidator.class
//)
//@Target({ElementType.FIELD, ElementType.PARAMETER})
//@Retention(RetentionPolicy.RUNTIME)
//public @interface PaymentValidation {
//    String message() default "{Invalid Payment Method}";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//}

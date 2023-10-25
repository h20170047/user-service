//package com.svj.Validation;
//
//import com.svj.utils.PropertiesLoader;
//import jakarta.annotation.PostConstruct;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.util.Set;
//
//public class PaymentValidator implements ConstraintValidator<PaymentValidation, String> {
//
//    private PropertiesLoader propertiesLoader;
//
//    public PaymentValidator(PropertiesLoader propertiesLoader){
//        this.propertiesLoader= propertiesLoader;
//    }
//    @Override
//    public void initialize(PaymentValidation constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }
//
//    @Override
//    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
//        if(propertiesLoader.getValidPaymentMethods().contains(input))
//            return true;
//        else
//            return false;
//    }
//}

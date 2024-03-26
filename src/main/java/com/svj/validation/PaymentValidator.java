package com.svj.validation;

import com.svj.annotations.ExcludeAop;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@ExcludeAop
//@ConfigurationProperties(prefix = "app")
public class PaymentValidator implements ConstraintValidator<PaymentValidation, String> {

    @Value("#{'${app.paymentMethods}'}")
    private String validPaymentMethodString;

//    public PaymentValidator(@Value("#{'${app.paymentMethods}'.split('\\s*,\\s*')}")
//                            Set<String> validPaymentMethods){
//        this.validPaymentMethods= validPaymentMethods;
//    }

//    private String paymentMethods;
//    public String getPaymentMethods() { return paymentMethods; }
//    public void setPaymentMethods(String paymentMethods) { this.paymentMethods = paymentMethods; }

    @Value("#{'${app.paymentMethods}'.split('\\s*,\\s*')}")
    private Set<String> validPaymentMethods;

    @Override
    public void initialize(PaymentValidation paymentValidation) {
        ConstraintValidator.super.initialize(paymentValidation);
        validPaymentMethods= new HashSet(){{
            add("UPI");
            add("CREDIT");
            add("DEBIT");
            add("COD");
        }};
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("+++++++++PaymentValidator: isValid- ValidPaymentMethods are : "+ validPaymentMethods);
        if(validPaymentMethods.contains(input))
            return true;
        else
            return false;
    }
}

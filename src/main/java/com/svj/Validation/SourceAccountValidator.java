//package com.svj.Validation;
//
//import com.svj.entity.User;
//import jakarta.annotation.PostConstruct;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.util.Set;
//
//public class SourceAccountValidator implements ConstraintValidator<SourceAccountValidation, User> {
//
////    @Value("#{'${app.paymentMethods}'.split(',')}")
////    private Set<String> validPaymentMethods;
//
//    @Override
//    public void initialize(SourceAccountValidation constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }
//
//
//    @Override
//    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
//        if(!user.getPaymentMethod().equals("COD") && user.getSrcAccount().isBlank())
//            return false;
//        // other validations based on UPI patterns and bank specific formats can be done
//        else
//            return true;
//    }
//}

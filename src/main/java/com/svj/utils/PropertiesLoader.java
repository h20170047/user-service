//package com.svj.utils;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Set;
//
//@Component
//public class PropertiesLoader {
//
//
////    @Value("#{'${app.paymentMethods}'.split(',')}")
////    private Set<String> validPaymentMethods; //= Arrays.asList("UPI", "CREDIT", "DEBIT", "COD");
//
////    @Value("#{'${app.paymentMethods}'.split(', ')}")
//    @Value("#{'${app.paymentMethods}'.split(',')}")
//    private Set<String> validPaymentMethods; //String>
//
////    @PostConstruct
////    public void init(){
//////        System.out.println("Valid Payment methods are "+validPaymentMethods);
////        System.out.println("And some string is "+someString);
////
////    }
//
//    public Set<String> getValidPaymentMethods(){
//        return validPaymentMethods; //validPaymentMethods;
//    }
//}

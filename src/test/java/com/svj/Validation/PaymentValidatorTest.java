package com.svj.Validation;

import com.svj.UserServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest(classes= UserServiceApplication.class)
class PaymentValidatorTest {

//    @Value("#{'${app.paymentMethods}'.split(',')}")
//    private Set<String> validPaymentMethods;

//    @Value("${server.port}")
//    private int port;

//    @Test
//    void isValid() {
//        PaymentValidator instance= new PaymentValidator();
//        assertThat(instance.isValid(null, null)).isFalse();
//        assertThat(instance.isValid("", null)).isFalse();
//        assertThat(instance.isValid("COD", null)).isTrue();
//    }

//    @Test
//    public void testMyProperty() {
//        assertEquals(9393, port);
//    }
}
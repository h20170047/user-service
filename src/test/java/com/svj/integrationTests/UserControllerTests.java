package com.svj.integrationTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.svj.controller.UserController;
import com.svj.dto.UserRequestDTO;
import com.svj.entity.User;
import com.svj.repository.UserRepository;
import com.svj.service.UserService;
import com.svj.validation.PaymentValidator;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
//@TestPropertySource(locations="classpath:application.properties")
//@ComponentScan(basePackages = "com.svj.validation")
//@ExtendWith(MockitoExtension.class) // mocks necessary dependencies using mocks to the field using @InjectMocks
public class UserControllerTests {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper= new ObjectMapper();
    @Autowired
    private UserService service;
    @Autowired
    private PaymentValidator paymentValidator; // To ensure that the fields in validator is populated correctly.
    @MockBean
    private UserRepository repository;
    @Autowired
    private UserController controller;

    @Value("#{'${app.paymentMethods}'}")
    private String validPaymentMethods;

    @BeforeEach
    public void setup(){
        this.mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testNewUserReg() throws Exception {
        log.info("Starting test case++++++++++++++++++++++");
        log.info("Valid Payment Methods are {}", validPaymentMethods);
        UserRequestDTO newUser= new UserRequestDTO(0,"John", "john@doe.com", "COD", "12345", 5000);
        User savedUser= new User(newUser.getId(), newUser.getName(), newUser.getEmail(), newUser.getPaymentMethod(), newUser.getSrcAccount(), newUser.getAvailableAmount());
        savedUser.setId(1);
        when(repository.save(any(User.class))).thenReturn(savedUser);
        //URL- /users
        //HTTP method- GET
        //REQ and RES-  User (Json String)
        mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .content(convertObjectToString(newUser))
                .contentType("application/json")
                .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id" ).exists());
    }

    private String convertObjectToString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

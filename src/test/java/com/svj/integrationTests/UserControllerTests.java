package com.svj.integrationTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.svj.controller.UserController;
import com.svj.dto.UserRequestDTO;
import com.svj.repository.UserRepository;
import com.svj.service.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
@AutoConfigureMockMvc
//@ExtendWith(MockitoExtension.class) // mocks necessary dependencies using mocks to the field using @InjectMocks
public class UserControllerTests {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper= new ObjectMapper();
    @Autowired
    private UserService service;
    @MockBean
    private UserRepository repository;
    @Autowired
    private UserController controller;

    @BeforeEach
    public void setup(){
        this.mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testNewUserReg() throws Exception {
        UserRequestDTO newUser= new UserRequestDTO(0,"John", "john@doe.com", "COD", "12345", 5000);
        UserRequestDTO savedUser= newUser;
        savedUser.setId(1);
        when(repository.save(any())).thenReturn(savedUser);
        //URL- /users
        //HTTP method- GET
        //REQ and RES-  User (Json String)
        mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .content(convertObjectToString(newUser))
                .contentType("application/json")
                .accept("application/json"))
//                .andDo(print())
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

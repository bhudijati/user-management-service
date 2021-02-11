package com.bjpu.user.controller;

import com.bjpu.user.domain.dto.UserManagementRequest;
import com.bjpu.user.exceptions.GenericException;
import com.bjpu.user.services.UserManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UserManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserManagementService userManagementService;

    @SneakyThrows
    @Test
    public void testValidateUserPin_expectSuccess_store() {
        mockMvc.perform(post("/v1/validatepin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(UserManagementRequest.builder()
                        .username("bjpu")
                        .pinTransaction("123456")
                        .build())))
                .andExpect(status().isOk());
    }

    @SneakyThrows
    @Test(expected = Exception.class)
    public void testValidateUserPin_expectFailed_store() {
        doThrow(GenericException.class).when(userManagementService).validatePin(any());
        mockMvc.perform(post("/v1/validatepin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(UserManagementRequest.builder()
                        .username("bjpu")
                        .pinTransaction("123456")
                        .build())))
                .andExpect(status().isBadRequest());
    }

}
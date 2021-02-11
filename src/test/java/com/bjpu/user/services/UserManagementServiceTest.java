package com.bjpu.user.services;

import com.bjpu.user.domain.dto.UserManagementRequest;
import com.bjpu.user.domain.entity.UserManagement;
import com.bjpu.user.repository.UserManagementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserManagementServiceTest {

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private UserManagementRepository userManagementRepository;

    @Test
    public void testValidatePin_expectSuccess_validated() {
        userManagementRepository.save(UserManagement.builder()
                .pinTransaction("123456")
                .username("bjpu")
                .build());
        boolean valid = userManagementService.validatePin(UserManagementRequest.builder()
                .username("bjpu")
                .pinTransaction("123456")
                .build());
        assertTrue(valid);
    }

    @Test
    public void testValidatePin_expectFailed_validated() {
        boolean valid = userManagementService.validatePin(UserManagementRequest.builder()
                .username("bjpus")
                .pinTransaction("000012")
                .build());
        assertFalse(valid);
    }
}
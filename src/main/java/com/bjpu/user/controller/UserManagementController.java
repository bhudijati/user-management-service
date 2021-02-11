package com.bjpu.user.controller;

import com.bjpu.user.domain.dto.UserManagementRequest;
import com.bjpu.user.services.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1")
@Slf4j
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping(value = "/validatepin")
    @ResponseBody
    public boolean validateUserPin(@RequestBody UserManagementRequest userManagementRequest) {
        try {
            return userManagementService.validatePin(userManagementRequest);
        } catch (Exception ex) {
            log.error("Exception happened when Validating PIN message [{}]", ex.getMessage());
            throw ex;
        }
    }
}

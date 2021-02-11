package com.bjpu.user.services;

import com.bjpu.user.domain.dto.UserManagementRequest;
import com.bjpu.user.repository.UserManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserManagementService {

    @Autowired
    private UserManagementRepository userManagementRepository;

    @Transactional
    public boolean validatePin(UserManagementRequest userManagementRequest) {
        int count = userManagementRepository.validatePin(userManagementRequest.getUsername(),
                userManagementRequest.getPinTransaction());
        return count == 1;
    }
}

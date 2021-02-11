package com.bjpu.user.repository;

import com.bjpu.user.domain.entity.UserManagement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserManagementRepository extends CrudRepository<UserManagement, Long> {


    @Query(value = "SELECT COUNT(*) FROM USER_MANAGEMENT " +
            "WHERE USERNAME=?1 AND PIN_TRANSACTION=?2", nativeQuery = true)
    int validatePin(String username, String pinTransaction);
}

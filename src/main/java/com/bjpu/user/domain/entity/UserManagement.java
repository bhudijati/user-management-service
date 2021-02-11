package com.bjpu.user.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserManagement implements Serializable {
    @Id
    @SequenceGenerator(name = "usermgmt", sequenceName = "usermgmtSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usermgmt")
    private Long idUserManagement;
    private String username;
    private String pinTransaction;
}

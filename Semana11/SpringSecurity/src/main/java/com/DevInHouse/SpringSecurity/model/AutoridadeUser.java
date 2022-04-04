package com.DevInHouse.SpringSecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autoridade")
public class AutoridadeUser {

    private String username;
    @Id
    private String autoridade;
}

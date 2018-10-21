package com.salmon.TO;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "roles")
@Table(name = "ROLES")
public class Roles implements Serializable{

        @Id
        @SequenceGenerator(name = "ROLES_SEQ",sequenceName = "ROLES_SEQ",allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.AUTO,generator = "ROLES_SEQ")
        @Column(name = "ID",columnDefinition = "SMALLINT")
        private long id;

        @Column(name = "USERNAME",columnDefinition = "CHAR(100)")
        private String username;

        @Column(name = "ROLENAME",columnDefinition = "CHAR(100)")
        private String roleName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

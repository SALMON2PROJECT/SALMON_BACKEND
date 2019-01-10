package com.salmon.TO;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "USERS")
@Entity(name = "users")
public class Users implements Serializable {

    @Id
    @SequenceGenerator(name = "USER_SEQ",sequenceName = "USER_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "USER_SEQ")
    @Column(name = "ID",columnDefinition = "SMALLINT")
    private long id;

    @Column(name = "USERNAME",columnDefinition = "CHAR(100)",unique = true)
    private String username;

    @Column(name = "USERPASS",columnDefinition = "CHAR(100)")
    private String userpass;

//    @Lob
//    @Column(name = "IMAGE",columnDefinition = "BLOB")
//    private byte[] pic;

//    public byte[] getPic() {
//        return pic;
//    }
//
//    public void setPic(byte[] pic) {
//        this.pic = pic;
//    }

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

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
}

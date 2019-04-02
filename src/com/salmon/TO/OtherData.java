package com.salmon.TO;

import javax.persistence.*;

@Table(name = "OTHERDATA")
@Entity(name = "otherData")
public class OtherData {
    @Id
    @SequenceGenerator(name = "OtherData_SEQ",sequenceName = "OtherData_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "OtherData_SEQ")
    private long id;

    @Column(name ="LINKADDRESS",columnDefinition = "CHAR(100)")
    private String linkAddress;

    @Column(name = "USERNAME",columnDefinition = "CHAR(100)")
    private String username;

    @Column(name = "LIKES",columnDefinition = "INT")
    private int like;

    @Column (name = "DISLIKE",columnDefinition = "INT")
    private int dislike;

    @Column(name = "PIN",columnDefinition = "BOOLEAN")
    private boolean pin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public boolean isPin() {
        return pin;
    }

    public void setPin(boolean pin) {
        this.pin = pin;
    }
}

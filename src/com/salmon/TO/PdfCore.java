package com.salmon.TO;



import javax.persistence.*;
import java.io.Serializable;



@Table(name = "PDFCORE")
@Entity(name = "pdfcore")
public class PdfCore implements Serializable {
    @Id
    @SequenceGenerator(name = "PDFCORE_SEQ",sequenceName = "PDFCORE_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "PDFCORE_SEQ")
    private long id;

    @Column(name = "UNIQUEHASH",columnDefinition ="CHAR(100)" )
    private String uniqueHash;

    @Column(name = "PDFCORE",columnDefinition ="CHAR(100)")
    private String pdfCore;

    @Column (name = "TAGS",columnDefinition = "CHAR(300)")
    private String tags;

    @Column(name = "DATE",columnDefinition = "CHAR(50)")
    private String date;

    @Column(name = "USERNAME",columnDefinition = "CHAR(50)")
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUniqueHash() {
        return uniqueHash;
    }

    public void setUniqueHash(String uniqueHash) {
        this.uniqueHash = uniqueHash;
    }

    public String getPdfCore() {
        return pdfCore;
    }

    public void setPdfCore(String pdfCore) {
        this.pdfCore = pdfCore;
    }

}


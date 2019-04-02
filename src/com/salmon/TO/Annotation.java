package com.salmon.TO;



import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Aprin on 1/20/2019.
 */
@Entity(name = "Ant")
@Table(name = "ANT")
public class Annotation implements Serializable {
    @Id
    @SequenceGenerator(name = "ANT_SEQ",sequenceName = "ANT_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ANT_SEQ")
    private long id;

    @Column(name = "LINK",columnDefinition = "CHAR(100)")
    private String link;

    @Column(name = "ANNOTATE",columnDefinition = "CHAR(700000)")
    private String  annotate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAnnotate() {
        return annotate;
    }

    public void setAnnotate(String annotate) {
        this.annotate = annotate;
    }
}

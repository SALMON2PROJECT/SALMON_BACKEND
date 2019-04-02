package com.salmon.TO;



import javax.persistence.*;
import java.io.Serializable;


@Table(name = "METADATACOLLECTION")
@Entity(name = "metaData")
public class MetadataCollection implements Serializable {
    @Id
    @SequenceGenerator(name = "MetaData_SEQ",sequenceName = "MetaData_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "MetaData_SEQ")
    private long id;

    @Column(columnDefinition ="char(10000)",name = "METADATA")
    private String metaData;

    @Column(name = "SEMANTICTAGS",columnDefinition = "CHAR(20000)")
    private String semanticTags;

    @Column(name = "PDFCORE",columnDefinition ="CHAR(100)" )
    private String pdfCore;

    @Column(columnDefinition = "CHAR(100)",name = "TITLE")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPdfCore() {
        return pdfCore;
    }

    public void setPdfCore(String pdfCore) {
        this.pdfCore = pdfCore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public String getSemanticTags() {
        return semanticTags;
    }

    public void setSemanticTags(String symanticTags) {
        this.semanticTags = symanticTags;
    }
}

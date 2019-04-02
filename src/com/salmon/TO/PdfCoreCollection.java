package com.salmon.TO;



import javax.persistence.*;
import java.io.Serializable;

@Table(name = "PdfCoreCollection")
@Entity(name = "PdfCoreCollection")

public class PdfCoreCollection implements Serializable{

    @Id
    @SequenceGenerator(name = "PdfCore_SEQ",sequenceName = "PdfCore_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "PdfCore_SEQ")
    private long id;

    @Column(columnDefinition = "Char(150)",name = "PDFCORE")
    private String pdfCore;

    @Column(columnDefinition = "CHAR(100)",name = "TITLE")
    private String title;

    @Column(columnDefinition = "smallint",name = "SCORE")
    private int score;

    @Column(columnDefinition = "CHAR(15000)",name = "PDFCOREMETADATA")
    private String pdfCoreMetaData;

    @Column(columnDefinition = "BOOLEAN",name = "RELEVANT")
    private boolean relevant;

    @Column(columnDefinition = "FLOAT(10)",name = "PERCENTAGE")
    private double percentage;

    public String getPdfCoreMetaData() {
        return pdfCoreMetaData;
    }

    public void setPdfCoreMetaData(String pdfCoreMetaData) {
        this.pdfCoreMetaData = pdfCoreMetaData;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @OneToOne()
    private MetadataCollection metadataCollection;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isRelevant() {
        return relevant;
    }

    public void setRelevant(boolean relevant) {
        this.relevant = relevant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPdfCore() {
        return pdfCore;
    }

    public void setPdfCore(String pdfCore) {
        this.pdfCore = pdfCore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MetadataCollection getMetadataCollection() {
        return metadataCollection;
    }

    public void setMetadataCollection(MetadataCollection metadataCollection) {
        this.metadataCollection = metadataCollection;
    }
}

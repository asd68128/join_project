package com.sl.automobile.pojo;

import java.io.Serializable;
import java.util.Date;

public class InformationTable implements Serializable {
    private int informationId;
    private String title;
    private Date informationCreateDate;
    private String liulancount;
    private String laiyuan;

    public InformationTable() {
    }

    public InformationTable(int informationId, String title, Date informationCreateDate, String liulancount, String laiyuan) {
        this.informationId = informationId;
        this.title = title;
        this.informationCreateDate = informationCreateDate;
        this.liulancount = liulancount;
        this.laiyuan = laiyuan;
    }

    public int getInformationId() {
        return informationId;
    }

    public void setInformationId(int informationId) {
        this.informationId = informationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getInformationCreateDate() {
        return informationCreateDate;
    }

    public void setInformationCreateDate(Date informationCreateDate) {
        this.informationCreateDate = informationCreateDate;
    }

    public String getLiulancount() {
        return liulancount;
    }

    public void setLiulancount(String liulancount) {
        this.liulancount = liulancount;
    }

    public String getLaiyuan() {
        return laiyuan;
    }

    public void setLaiyuan(String laiyuan) {
        this.laiyuan = laiyuan;
    }

    @Override
    public String toString() {
        return "InformationTable{" +
                "informationId=" + informationId +
                ", title='" + title + '\'' +
                ", informationCreateDate=" + informationCreateDate +
                ", liulancount='" + liulancount + '\'' +
                ", laiyuan='" + laiyuan + '\'' +
                '}';
    }
}

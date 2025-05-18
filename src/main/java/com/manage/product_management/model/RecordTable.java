package com.manage.product_management.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RecordTable")
public class RecordTable {

    @Id
    @Column(name = "Item_No")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_no;

    @Column(name = "Track_Id")
    private String trackId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Comp_Name")
    private String compName;

    @Column(name = "remark")
    private String remark;

    @Column(name = "Status")
    private String status;

    @Column(name = "Contact")
    private  String number;

    @Column(name = "Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /*@PrePersist
    void onCreate()
    {
        date=new Date();
        status="Unpicked";
    }
*/
    public RecordTable() {
    }

    public RecordTable(Long item_no, String trackId, String name, String compName, String remark, String status, String number, Date date) {
        this.item_no = item_no;
        this.trackId = trackId;
        this.name = name;
        this.compName = compName;
        this.remark = remark;
        this.status = status;
        this.number = number;
        this.date = date;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public Long getItem_no() {
        return item_no;
    }

    public void setItem_no(Long item_no) {
        this.item_no = item_no;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RecordTable{" +
                "item_no=" + item_no +
                ", trackId='" + trackId + '\'' +
                ", name='" + name + '\'' +
                ", compName='" + compName + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", number='" + number + '\'' +
                ", date=" + date +
                '}';
    }
}

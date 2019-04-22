package com.example.demo.DataRecordTable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
 
@Entity
@Table(name = "RecordTable")
public class RecordTable {
	
	@Id
    @Column(name = "Item_No")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long item_no;
	
	@NotNull
	@Column(name = "Tracking_Id")
    String track_id;
	
	
    @NotNull
    @Column(name = "Name")
    String name;
    
    @NotNull
    @Column(name = "Company_Name")
    String comp_name;
    
    @Column(name = "remark")
    String remark;
    
    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "Status")
    String status;
 
    @Column(name = "Date")
    Date date;
    
    @PrePersist
    void onCreate()
    {
    	date=new Date();
    	status="Unpicked";
    }
    
    public Long getItem_no() {
		return item_no;
	}

	public void setItem_no(Long item_no) {
		this.item_no = item_no;
	}

	public String getTrack_id() {
		return track_id;
	}

	public void setTrack_id(String track_id) {
		this.track_id = track_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

package com.insurance.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CATEGORY_DETAILS")
@Data
public class PlanCategory {

	@Id
	@Column(name = "CATEGORY_ID")
	private Integer categoryID;
	
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	
	@Column(name = "ACTIVE_STATUS")
	private String activeSwitch;
	
	@Column(name = "PLAN_CREATED_BY")
	private String createdBy;
	
	@Column(name = "PLAN_CREATION_DATE")
	private LocalDate creationDate;
	
	@Column(name = "PLAN_UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "PLAN_UPDATION_DATE")
	private LocalDate updationDate;
}

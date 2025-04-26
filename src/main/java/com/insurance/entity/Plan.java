package com.insurance.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PLAN_MASTER")
@Data
public class Plan {

	@Id
	@GeneratedValue
	@Column(name = "PLAN_ID")
	private Integer planId;

	@Column(name = "PLAN_NAME")
	private String planName;

	@Column(name = "PLAN_CATEGORY_ID")
	private Integer categoryID;

	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;

	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;

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

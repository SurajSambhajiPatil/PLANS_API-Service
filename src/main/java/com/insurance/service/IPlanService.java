package com.insurance.service;

import java.util.List;
import java.util.Map;

import com.insurance.entity.Plan;

public interface IPlanService {

	public Map<Integer, String> getAllPlanCategories();
	
	public boolean upsertPlan(Plan plan);
	
	public Plan getPlanByID(Integer planId);
	
	public List<Plan> getAllPlans();
	
	public boolean deletePlanById(Integer planId);
	
	public boolean planStatusChange(Integer planId, String status);
}

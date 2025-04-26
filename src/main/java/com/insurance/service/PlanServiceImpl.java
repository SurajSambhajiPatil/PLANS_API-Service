package com.insurance.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entity.Plan;
import com.insurance.entity.PlanCategory;
import com.insurance.repo.IPlanCategoryRepository;
import com.insurance.repo.IPlanRepository;

@Service
public class PlanServiceImpl implements IPlanService {

	@Autowired
	private IPlanRepository repository;

	@Autowired
	private IPlanCategoryRepository categoryRepository;

	@Override
	public Map<Integer, String> getAllPlanCategories() {
		List<PlanCategory> findAll = categoryRepository.findAll();
		Map<Integer, String> map = new HashMap<>();
		findAll.forEach(category -> map.put(category.getCategoryID(), category.getCategoryName()));
		return map;
	}

	@Override
	public boolean upsertPlan(Plan plan) {
		Optional<Plan> findById = repository.findById(plan.getPlanId());
		return findById != null;
	}

	@Override
	public Plan getPlanByID(Integer planId) {
		Optional<Plan> findById = repository.findById(planId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Plan> getAllPlans() {
		List<Plan> allPlans = repository.findAll();
		return allPlans;
	}

	@Override
	public boolean deletePlanById(Integer planId) {

		boolean status = false;
		try {
			repository.deleteById(planId);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {

		Optional<Plan> findById = repository.findById(planId);
		if (findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSwitch(status);
			repository.save(plan);
			return true;
		}
		return false;
	}

}

package com.insurance.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.constants.AppConstants;
import com.insurance.entity.Plan;
import com.insurance.props.AppProperties;
import com.insurance.service.IPlanService;

@RestController
public class PlanController {

	private IPlanService planService;
	private Map<String, String> messages;
	
	public PlanController(IPlanService planService, AppProperties appProperties) {
		super();
		this.planService = planService;
		this.messages = appProperties.getMessages();
	}

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> getPlanCategory(){
		Map<Integer,String> allPlanCategories = planService.getAllPlanCategories();
		return new ResponseEntity<>(allPlanCategories, HttpStatus.OK);
	}

	@GetMapping("/plan")
	public ResponseEntity<Plan> getPlanById(@PathVariable int planId){
		Plan planById = planService.getPlanByID(planId);
		return new ResponseEntity<>(planById,HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		
		boolean upsertPlan = planService.upsertPlan(plan);
		String planMsg = AppConstants.EMPTY_STR;
		if(upsertPlan) {
			planMsg = "Plan Saved Successfully..";
		}else {
			planMsg = "Plan Not Saved..";
		}
		return new ResponseEntity<>(planMsg,HttpStatus.CREATED);
	}

	@PostMapping("/update/{planID}")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		boolean upsertPlan = planService.upsertPlan(plan);
		String planMsg ;
		if(upsertPlan) {
			planMsg = "Plan updated Successfully..";
		}else {
			planMsg = "Plan Not updated..";
		}
		return new ResponseEntity<>(planMsg,HttpStatus.CREATED);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean deletePlanById = planService.deletePlanById(planId);
		String planMsg ;
		if(deletePlanById) {
			planMsg = "Plan updated Successfully..";
		}else {
			planMsg = "Plan Not updated..";
		}
		return new ResponseEntity<>(planMsg,HttpStatus.CREATED);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan plan = planService.getPlanByID(planId);
		return new ResponseEntity<>(plan,HttpStatus.OK);
	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId, @PathVariable String status){
		boolean planStatusChange = planService.planStatusChange(planId, status);
		String planStatusMsg ;
		if(planStatusChange) {
			planStatusMsg ="Plan Status Updated Successfully..";
		}else {
			planStatusMsg ="Plan Status Not Updated..";
		}
		return new ResponseEntity<>(planStatusMsg,HttpStatus.ACCEPTED);
	}
}

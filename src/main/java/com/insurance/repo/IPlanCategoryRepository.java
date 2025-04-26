package com.insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.PlanCategory;

public interface IPlanCategoryRepository extends JpaRepository<PlanCategory, Integer> {

}

package com.insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.Plan;

public interface IPlanRepository extends JpaRepository<Plan, Integer> {

}

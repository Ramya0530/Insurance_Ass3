package com.example.insurance_policy.repository;

import com.example.insurance_policy.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StateRepository extends JpaRepository<State,Integer> {
}

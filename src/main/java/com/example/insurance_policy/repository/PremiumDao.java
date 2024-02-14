package com.example.insurance_policy.repository;

import com.example.insurance_policy.entity.Premium;

import java.util.List;

public interface PremiumDao {
    List<Premium> findAll();

    Premium findById(int id);

    Premium findByIdCov(String coverageId, String state_id);
}

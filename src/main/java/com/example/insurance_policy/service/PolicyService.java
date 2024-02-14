package com.example.insurance_policy.service;

import com.example.insurance_policy.entity.Policy;

import java.util.List;

public interface PolicyService {
    List<Policy> getAllPolicy();
    Policy findById(int policy_id);
    Policy save(Policy policy);
    Policy update(Policy policy);
    void delete(int policy_id);

}

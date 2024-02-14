package com.example.insurance_policy.service;

import com.example.insurance_policy.entity.Coverage;
import com.example.insurance_policy.entity.Policy;
import com.example.insurance_policy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService{
    @Autowired
    PolicyRepository repository;
    @Autowired
    CoverageService coverageService;
    @Override
    public List<Policy> getAllPolicy() {
        return repository.findAll();
    }

    @Override
    public Policy findById(int policy_id) {
        return repository.findById(policy_id).orElse(null);
    }

    @Override
    public Policy save(Policy policy) {
        return repository.save(policy);
    }

    @Override
    public Policy update(Policy policy) {
        return repository.save(policy);
    }

    @Override
    public void delete(int policy_id) {
        repository.deleteById(policy_id);
    }


}

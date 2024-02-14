package com.example.insurance_policy.service;

import com.example.insurance_policy.entity.Coverage;
import com.example.insurance_policy.repository.CoverageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoverageServiceImpl implements CoverageService{
    @Autowired
    CoverageDao repository;
    @Override
    public List<Coverage> getALlCoverage() {
        return repository.findAll();
    }

    @Override
    public Coverage findById(int cov_id) {
        return repository.findById(cov_id);
    }
}

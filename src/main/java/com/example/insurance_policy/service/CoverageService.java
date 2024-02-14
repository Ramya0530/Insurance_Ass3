package com.example.insurance_policy.service;

import com.example.insurance_policy.entity.Coverage;

import java.util.List;

public interface CoverageService {
    List<Coverage> getALlCoverage();
    Coverage findById(int cov_id);
}

package com.example.insurance_policy.repository;

import com.example.insurance_policy.entity.Coverage;

import java.util.List;

public interface CoverageDao {
    List<Coverage> findAll();

    Coverage findById(int cov_id);
}

package com.example.insurance_policy.repository;

import com.example.insurance_policy.entity.Coverage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoverageDaoImpl implements CoverageDao{

    @Autowired
    EntityManager entityManager;
    @Override
    public List<Coverage> findAll() {
        TypedQuery<Coverage> typedQuery = entityManager.createQuery("from Coverage",Coverage.class);
        List <Coverage> coverage =  typedQuery.getResultList();
        return coverage;

    }

    @Override
    public Coverage findById(int cov_id) {
        Coverage coverage=entityManager.find(Coverage.class,cov_id);
        return coverage;
    }
}

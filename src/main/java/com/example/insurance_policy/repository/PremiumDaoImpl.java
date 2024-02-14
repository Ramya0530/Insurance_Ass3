package com.example.insurance_policy.repository;

import com.example.insurance_policy.entity.Premium;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PremiumDaoImpl implements PremiumDao{

    @Autowired
    EntityManager entityManager;
    @Override
    public List<Premium> findAll() {
        TypedQuery<Premium> typedQuery = entityManager.createQuery("from Premium ",Premium.class);
        List<Premium> premiums = typedQuery.getResultList();
        return premiums;
    }

    @Override
    public Premium findById(int id) {
        Premium premium = entityManager.find(Premium.class,id);
        return premium;
    }

    @Override
    public Premium findByIdCov(String coverageId, String state_id) {
        Premium premium = entityManager.createQuery("from Coverage c inner join State s on c.cov_id = s.state_id where c.cov_id =?",Premium.class).getSingleResult();
        return  premium;
    }

}

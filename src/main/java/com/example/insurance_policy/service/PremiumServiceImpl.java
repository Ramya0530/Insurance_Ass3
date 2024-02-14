package com.example.insurance_policy.service;

import com.example.insurance_policy.entity.Premium;
import com.example.insurance_policy.repository.PremiumDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PremiumServiceImpl implements PremiumService{
    @Autowired
    PremiumDao premiumDao;

    @Override
    public double calculate(String[] Coverage_id, String State_id) {
        int rate =0;
        for(String cid:Coverage_id){
            Premium premium= premiumDao.findByIdCov(cid,State_id);
            if(premium!=null){
                rate += premium.getRate();
            }
        }
        return rate;
    }
}

package com.example.insurance_policy.service;

import com.example.insurance_policy.entity.State;
import com.example.insurance_policy.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService{
    @Autowired
    StateRepository repository;

    @Override
    public List<State> getAllState() {
        return repository.findAll();
    }

    @Override
    public State findById(int state_id) {
        return repository.findById(state_id).orElse(null);
    }
}

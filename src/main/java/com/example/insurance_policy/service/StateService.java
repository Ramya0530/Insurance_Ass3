package com.example.insurance_policy.service;

import com.example.insurance_policy.entity.State;

import java.util.List;

public interface StateService {
    List<State> getAllState();
    State findById(int state_id);
}

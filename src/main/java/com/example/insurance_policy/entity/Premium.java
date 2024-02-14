package com.example.insurance_policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Premium {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "Coverage_id")
    private int Coverage_id;
    @Column(name = "State_id")
    private int State_id;
    @Column(name = "rate")
    private int rate;


    public Premium() {
    }

    public Premium(int id, int coverage_id, int state_id, int rate) {
        this.id = id;
        Coverage_id = coverage_id;
        State_id = state_id;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoverage_id() {
        return Coverage_id;
    }

    public void setCoverage_id(int coverage_id) {
        Coverage_id = coverage_id;
    }

    public int getState_id() {
        return State_id;
    }

    public void setState_id(int state_id) {
        State_id = state_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Premium{" +
                "id=" + id +
                ", Coverage_id=" + Coverage_id +
                ", State_id=" + State_id +
                ", rate=" + rate +
                '}';
    }
}

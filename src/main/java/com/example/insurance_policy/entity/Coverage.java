package com.example.insurance_policy.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity

public class Coverage {
    @Id
    @Column(name = "coverage_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cov_id;
    @Column(name = "coverage_name")
    private String cov_name;

    @ManyToMany(mappedBy = "coverages")
    private List<Policy> policy;

    public Coverage() {
    }

    public Coverage(int cov_id, String cov_name) {
        this.cov_id = cov_id;
        this.cov_name = cov_name;
    }

    public int getCov_id() {
        return cov_id;
    }

    public void setCov_id(int cov_id) {
        this.cov_id = cov_id;
    }

    public String getCov_name() {
        return cov_name;
    }

    public void setCov_name(String cov_name) {
        this.cov_name = cov_name;
    }

    public List<Policy> getPolicy() {
        return policy;
    }

    public void setPolicy(List<Policy> policy) {
        this.policy = policy;
    }

    @Override
    public String toString() {
        return "Coverage{" +
                "cov_id=" + cov_id +
                ", cov_name='" + cov_name + '\'' +
                '}';
    }
}

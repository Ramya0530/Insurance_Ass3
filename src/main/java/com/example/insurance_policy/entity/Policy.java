package com.example.insurance_policy.entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
@Table(name = "Policy")
public class Policy {
    @Id
    @Column(name = "policy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policy_id;
    @Column(name = "policy_holdername")
    private String policy_name;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    private String status;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST})
    private State states;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "Policy_Coverage",
            joinColumns = {@JoinColumn(name = "policy_id")}
            , inverseJoinColumns = {@JoinColumn(name = "coverage_id")})
    private List<Coverage> coverages;

    public Policy(int policy_id, String policy_name, String address1, String address2,String status) {
        this.policy_id = policy_id;
        this.policy_name = policy_name;
        this.address1 = address1;
        this.address2 = address2;
        this.status = status;
    }

    public Policy() {
    }

    public int getPolicy_id() {
        return policy_id;
    }

    public void setPolicy_id(int policy_id) {
        this.policy_id = policy_id;
    }

    public String getPolicy_name() {
        return policy_name;
    }

    public void setPolicy_name(String policy_name) {
        this.policy_name = policy_name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public State getStates() {
        return states;
    }

    public void setStates(State states) {
        this.states = states;
    }

    public List<Coverage> getCoverages() {
        return coverages;
    }

    public void setCoverages(List<Coverage> coverages) {
        this.coverages = coverages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policy_id=" + policy_id +
                ", policy_name='" + policy_name + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", status='" + status + '\'' +
                ", states=" + states +
                ", coverages=" + coverages +
                '}';
    }
}

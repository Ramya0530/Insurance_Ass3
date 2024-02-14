package com.example.insurance_policy.controller;

import com.example.insurance_policy.entity.*;
import com.example.insurance_policy.service.CoverageService;
import com.example.insurance_policy.service.PolicyService;
import com.example.insurance_policy.service.PremiumService;
import com.example.insurance_policy.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Policy")
public class PolicyController {

    @Autowired
    PolicyService service;
    @Autowired
    StateService stateService;
    @Autowired
    CoverageService coverageService;
    @Autowired
    PremiumService premiumService;
    private String status = "Draft";


    @GetMapping("/save")
    public String get(Model model) {
        model.addAttribute("status", status);
        model.addAttribute("policy", new Policy());
        model.addAttribute("states", stateService.getAllState());
        model.addAttribute("coverages", coverageService.getALlCoverage());

        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("policy") Policy policy, @RequestParam(value = "state") String stateid, @RequestParam(value = "coverage") String[] covid, Model model) {

        List<Coverage> coverageList = new ArrayList<>();
        for (String cid : covid) {
            Coverage coverage = coverageService.findById(Integer.parseInt(cid));
            coverageList.add(coverage);
        }
        policy.setCoverages(coverageList);
        State state1 = stateService.findById(Integer.parseInt(stateid));
        policy.setStates(state1);
        policy.setStatus("Draft");
        //service.save(policy);
        return "redirect:/Policy/premium";
    }

    @GetMapping("/premium")
    public String premium(@ModelAttribute("policy") Policy policy, @RequestParam(value = "state") String stateid, @RequestParam(value = "coverage") String[] covid, Model model) {
        int premium = (int) premiumService.calculate(covid, stateid);
        model.addAttribute("premium", premium);
        policy.setStatus("bound");
        service.save(policy);
        return "premium";
    }

    @GetMapping("/view")
    public String view(Model model) {
        List<Policy> policies = service.getAllPolicy();
        List<State> states = stateService.getAllState();
        List<Coverage> coverages = coverageService.getALlCoverage();

        model.addAttribute("policies", policies);
        model.addAttribute("states", states);
        model.addAttribute("coverages", coverages);

        return "view";
    }
}
package com.javatechie.report.controller;

import com.javatechie.report.entity.BengaliEntry;
import com.javatechie.report.repository.BengaliEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BengaliControllerMVC {

    @Autowired
    private BengaliEntryRepository bengaliEntryRepository;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("bengaliEntry", new BengaliEntry());
        return "bengali-form";
    }

    @PostMapping("/form")
    public String submitForm(BengaliEntry bengaliEntry) {
        bengaliEntryRepository.save(bengaliEntry);
        return "redirect:/form";
    }
}

package com.javatechie.report.chiper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class YourController {

    @GetMapping("/yourMapping")
    public String yourHandler(Model model) {
        List<String> allOptions1 = Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4");
        List<String> selectedOptions1 = Arrays.asList("Option 1", "Option 3");

        List<String> allOptions2 = Arrays.asList("Choice A", "Choice B", "Choice C", "Choice D");
        List<String> selectedOptions2 = Arrays.asList("Choice A", "Choice C");

        model.addAttribute("allOptions1", allOptions1);
        model.addAttribute("selectedOptions1", selectedOptions1);

        model.addAttribute("allOptions2", allOptions2);
        model.addAttribute("selectedOptions2", selectedOptions2);

        return "yourTemplate";
    }
}


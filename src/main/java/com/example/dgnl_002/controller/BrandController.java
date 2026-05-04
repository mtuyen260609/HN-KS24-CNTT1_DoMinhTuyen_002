package com.example.dgnl_002.controller;

import com.example.dgnl_002.model.Brand;
import com.example.dgnl_002.repository.BrandRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandRepository brandRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("brands", brandRepository.findAll());
        return "brand/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("brand", new Brand());
        return "brand/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Brand brand,
                       BindingResult result) {
        if (result.hasErrors()) {
            return "brand/form";
        }
        brandRepository.save(brand);
        return "redirect:/brands";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        model.addAttribute("brand", brand);
        return "brand/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        brandRepository.deleteById(id);
        return "redirect:/brands";
    }
}

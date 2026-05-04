package com.example.dgnl_002.controller;

import com.example.dgnl_002.model.Device;
import com.example.dgnl_002.repository.BrandRepository;
import com.example.dgnl_002.repository.DeviceRepository;
import com.example.dgnl_002.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceRepository deviceRepository;
    private final BrandRepository brandRepository;
    @GetMapping
    public String list(Model model) {
        model.addAttribute("devices", deviceRepository.findAll());
        return "device/list";
    }
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("device", new Device());
        model.addAttribute("brands", brandRepository.findAll());
        return "device/form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Device device) {
        deviceRepository.save(device);
        return "redirect:/devices";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Device device = deviceRepository.findById(id).orElseThrow();
        model.addAttribute("device", device);
        model.addAttribute("brands", brandRepository.findAll());
        return "device/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        deviceRepository.deleteById(id);
        return "redirect:/devices";
    }
}

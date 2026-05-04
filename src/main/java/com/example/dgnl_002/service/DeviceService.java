package com.example.dgnl_002.service;

import com.example.dgnl_002.model.Device;
import com.example.dgnl_002.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository repo;
    public List<Device> findAll() {
        return repo.findAll();
    }
    public Device findById(Long id) {
        return repo.findById(id).orElse(null);
    }
    public Device save(Device device) {
        return repo.save(device);
    }
    public Device update(Device device) {
        return repo.save(device);
    }
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}

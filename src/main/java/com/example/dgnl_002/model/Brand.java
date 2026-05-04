package com.example.dgnl_002.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Device> devices;

}

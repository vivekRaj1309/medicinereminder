package com.springboot.medicinereminder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Medicine extends BaseModel{
    private String name;
    private int dosage;
    @ManyToOne
    private Duration duration;
    @ManyToOne
    private Stock stock;
    @ManyToMany
    private List<Frequency> frequencies;
}

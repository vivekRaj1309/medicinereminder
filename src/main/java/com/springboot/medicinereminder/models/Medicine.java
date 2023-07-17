package com.springboot.medicinereminder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Medicine extends BaseModel{
    private String name;
    @ManyToOne
    private Duration duration;
    @ManyToOne
    private Stock stock;
    @ManyToMany
    private List<Frequency> frequencies;
}

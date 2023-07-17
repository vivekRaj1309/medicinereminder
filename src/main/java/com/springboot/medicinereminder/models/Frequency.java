package com.springboot.medicinereminder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
@Entity
public class Frequency extends BaseModel{
    private LocalTime time;
    @ManyToMany(mappedBy = "frequencies")
    private List<Medicine> medicines;
}


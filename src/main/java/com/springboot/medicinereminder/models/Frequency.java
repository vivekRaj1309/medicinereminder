package com.springboot.medicinereminder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Frequency extends BaseModel{
    private LocalTime time;
    @ManyToMany(mappedBy = "frequencies")
    private List<Medicine> medicines;

}


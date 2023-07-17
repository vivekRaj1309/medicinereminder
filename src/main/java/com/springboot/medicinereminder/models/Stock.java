package com.springboot.medicinereminder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Stock extends BaseModel{
    private int value;
    @OneToMany(mappedBy = "stock")
    private List<Medicine> medicines;
}

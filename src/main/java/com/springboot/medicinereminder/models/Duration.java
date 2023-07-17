package com.springboot.medicinereminder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Duration extends BaseModel{
    private Date startDate;
    private Date endDate;
    @OneToMany(mappedBy = "duration")
    private List<Medicine> medicines;
}

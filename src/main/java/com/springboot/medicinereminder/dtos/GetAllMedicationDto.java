package com.springboot.medicinereminder.dtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class GetAllMedicationDto {
    private String medicineName;
    private int dosage;
    private LocalTime time;
    private Date startDate;
    private Date endDate;
    private int stock;

    public GetAllMedicationDto(String medicineName, int dosage, LocalTime time, Date startDate, Date endDate, int stock) {
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.time = time;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stock = stock;
    }
}

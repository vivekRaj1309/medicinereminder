package com.springboot.medicinereminder.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class GetAllMedicationDto {
    private String medicineName;
    private LocalTime time;
    private Date startDate;
    private Date endDate;
    private int stock;

    public GetAllMedicationDto(String medicineName, LocalTime time, Date startDate, Date endDate, int stock) {
        this.medicineName = medicineName;
        this.time = time;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stock = stock;
    }
}

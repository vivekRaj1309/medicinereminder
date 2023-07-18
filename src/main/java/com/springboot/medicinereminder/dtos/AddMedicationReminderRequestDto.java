package com.springboot.medicinereminder.dtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
public class AddMedicationReminderRequestDto {
    private String name;
    private int dosage;
    private List<LocalTime> frequencyList;
    private Date startDate;
    private Date endDate;
    private int stockValue;

    public AddMedicationReminderRequestDto(String name, int dosage, List<LocalTime> frequencyList, Date startDate, Date endDate, int stockValue) {
        this.name = name;
        this.dosage = dosage;
        this.frequencyList = frequencyList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stockValue = stockValue;
    }
}

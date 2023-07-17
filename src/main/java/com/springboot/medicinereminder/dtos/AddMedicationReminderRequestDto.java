package com.springboot.medicinereminder.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AddMedicationReminderRequestDto {
    private String name;
    private List<LocalTime> frequencyList;
    private Date startDate;
    private Date endDate;
    private int stockValue;
}

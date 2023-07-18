package com.springboot.medicinereminder.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class DeleteMedicationReminderByDatesDto {
    Date startDate;
    Date endDate;

}

package com.springboot.medicinereminder.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DeleteMedicationReminderByDatesDto {
    Date startDate;
    Date endDate;
}

package com.springboot.medicinereminder.service;

import com.springboot.medicinereminder.Repositories.DurationRepository;
import com.springboot.medicinereminder.Repositories.MedicationRepository;
import com.springboot.medicinereminder.models.Duration;
import com.springboot.medicinereminder.models.Medicine;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DeleteMedicationReminderService {
    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    DurationRepository durationRepository;

    @Transactional
    public String deleteMedicationByName(String name){
        Medicine existingMedicine = medicationRepository.findByName(name);
        if(existingMedicine == null) return "Medicine Not Found";
        medicationRepository.deleteByName(name);
        return "Medicine reminder for " + name + " successfully deleted";
    }

    @Transactional
    public String deleteMedicationByDates(Date startDate, Date endDate) {
        Duration existingDuration = durationRepository.findByStartDateAndEndDate(startDate, endDate);
        if(existingDuration != null){
            Medicine existingMedicine = medicationRepository.findByDuration(existingDuration);
            if(existingMedicine != null){
                medicationRepository.deleteByName(existingMedicine.getName());
            }
            durationRepository.deleteById(existingDuration.getId());
            return "Medication deleted by date";
        }
        return "Date not found";
    }
}

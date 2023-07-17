package com.springboot.medicinereminder.Controllers;

import com.springboot.medicinereminder.dtos.AddMedicationReminderRequestDto;
import com.springboot.medicinereminder.dtos.DeleteMedicationReminderByDatesDto;
import com.springboot.medicinereminder.dtos.DeleteMedicationReminderByNameDto;
import com.springboot.medicinereminder.dtos.GetAllMedicationDto;
import com.springboot.medicinereminder.service.AddMedicationReminderService;
import com.springboot.medicinereminder.service.DeleteMedicationReminderService;
import com.springboot.medicinereminder.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationReminderController {
    @Autowired
    MedicationService medicationService;
    @Autowired
    AddMedicationReminderService addMedicationReminderService;
    @Autowired
    DeleteMedicationReminderService deleteMedicationReminderService;

    @GetMapping
    public ResponseEntity<List<GetAllMedicationDto>> getAllMedications(){
        List<GetAllMedicationDto> medications= medicationService.getMedicineWithDurationStockAndFrequency();
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    @PostMapping("/medication-reminders")
    public ResponseEntity<String> addNewMedicationReminder(@RequestBody AddMedicationReminderRequestDto addRequest){
        addMedicationReminderService.addMedicationService(addRequest.getName(), addRequest.getFrequencyList(),
                addRequest.getStartDate(), addRequest.getEndDate(), addRequest.getStockValue());
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
    @DeleteMapping("/medication-reminders/{name}")
    public ResponseEntity<Void> deleteMedicationReminderByName(@PathVariable DeleteMedicationReminderByNameDto deleteByNameRequest){
        deleteMedicationReminderService.deleteMedicationByName(deleteByNameRequest.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/medication-reminders")
    public ResponseEntity<Void> deleteMedicationReminder(@RequestBody DeleteMedicationReminderByDatesDto deleteByDateRequest){
        deleteMedicationReminderService.deleteMedicationByDates(deleteByDateRequest.getStartDate(), deleteByDateRequest.getEndDate());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.springboot.medicinereminder.Controllers;

import com.springboot.medicinereminder.dtos.AddMedicationReminderRequestDto;
import com.springboot.medicinereminder.dtos.DeleteMedicationReminderByDatesDto;
import com.springboot.medicinereminder.dtos.DeleteMedicationReminderByNameDto;
import com.springboot.medicinereminder.dtos.GetAllMedicationDto;
import com.springboot.medicinereminder.service.AddMedicationReminderService;
import com.springboot.medicinereminder.service.DeleteMedicationReminderService;
import com.springboot.medicinereminder.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medications")
public class MedicationReminderController {
    @Autowired
    MedicineService medicineService;
    @Autowired
    AddMedicationReminderService addMedicationReminderService;
    @Autowired
    DeleteMedicationReminderService deleteMedicationReminderService;

    @GetMapping("/add-medication-reminder")
    public String showAddMedicationReminderPage() {
        return "addmedicationform";
    }
    @GetMapping
    public String showMedicationsPage(){
        return "getmedications";
    }
    @GetMapping("/get-all-medications")
    public ResponseEntity<List<GetAllMedicationDto>> getAllMedications(){
        List<GetAllMedicationDto> medications= medicineService.getMedicineWithDurationStockAndFrequency();
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    @PostMapping("/medication-reminders")
    public ResponseEntity<String> addNewMedicationReminder(@RequestBody AddMedicationReminderRequestDto addRequest){
        addMedicationReminderService.addMedicationService(addRequest.getName(), addRequest.getDosage(), addRequest.getFrequencyList(),
                addRequest.getStartDate(), addRequest.getEndDate(), addRequest.getStockValue());
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
    @DeleteMapping("/medication-reminders-with-name")
    public ResponseEntity<Void> deleteMedicationReminderByName(@RequestBody DeleteMedicationReminderByNameDto deleteByNameRequest){
        deleteMedicationReminderService.deleteMedicationByName(deleteByNameRequest.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/medication-reminders-with-date")
    public ResponseEntity<Void> deleteMedicationReminder(@RequestBody DeleteMedicationReminderByDatesDto deleteByDateRequest){
        deleteMedicationReminderService.deleteMedicationByDates(deleteByDateRequest.getStartDate(), deleteByDateRequest.getEndDate());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

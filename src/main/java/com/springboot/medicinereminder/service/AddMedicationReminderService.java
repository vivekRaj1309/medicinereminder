package com.springboot.medicinereminder.service;

import com.springboot.medicinereminder.Repositories.MedicationRepository;
import com.springboot.medicinereminder.models.Duration;
import com.springboot.medicinereminder.models.Frequency;
import com.springboot.medicinereminder.models.Medicine;
import com.springboot.medicinereminder.models.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class AddMedicationReminderService {
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private DurationService durationService;
    @Autowired
    private FrequencyService frequencyService;
    @Autowired
    private StockService stockService;
    @Autowired
    MedicationRepository medicationRepository;
    public void addMedicationService(String name,  int dosage, List<LocalTime> timeList, Date startDate, Date endDate, int stockValue){
        Duration duration = durationService.addNewDuration(startDate, endDate);
        Stock stock = stockService.addNewStock(stockValue);
        Medicine medicine = medicineService.addNewMedication(name, duration, stock, dosage);
        List<Frequency> frequencyList = frequencyService.addNewFrequency(timeList);
        medicine.setDuration(duration);
        medicine.setStock(stock);
        medicine.setFrequencies(new ArrayList<>(frequencyList));
        medicationRepository.save(medicine);
    }
}

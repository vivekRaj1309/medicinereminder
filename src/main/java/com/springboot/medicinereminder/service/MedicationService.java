package com.springboot.medicinereminder.service;

import com.springboot.medicinereminder.Repositories.MedicationRepository;
import com.springboot.medicinereminder.dtos.GetAllMedicationDto;
import com.springboot.medicinereminder.models.Duration;
import com.springboot.medicinereminder.models.Medicine;
import com.springboot.medicinereminder.models.Stock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {
    @Autowired
    MedicationRepository medicationRepository;

    @Autowired
    private EntityManager entityManager;
    public Medicine addNewMedication(String name, Duration duration, Stock stock) {
        Medicine existingMedicine = medicationRepository.findByName(name);
        if(existingMedicine == null){
            Medicine medicine = new Medicine();
            medicine.setName(name);
            medicine.setDuration(duration);
            medicine.setStock(stock);
            existingMedicine = medicationRepository.save(medicine);
        } else {
            existingMedicine.setDuration(duration);
            existingMedicine.setStock(stock);
        }
        return existingMedicine;
    }

    public List<GetAllMedicationDto> getMedicineWithDurationStockAndFrequency(){
        String jpql = "SELECT NEW com.springboot.medicinereminder.dtos.GetAllMedicationDto(m.name, f.time, d.startDate, d.endDate, s.value as stock) " +
                "FROM Medicine m " +
                "JOIN m.duration d "+
                "JOIN m.stock s " +
                "JOIN m.frequencies f " +
                "ORDER BY f.time ";
        TypedQuery<GetAllMedicationDto> query = entityManager.createQuery(jpql, GetAllMedicationDto.class);
        return query.getResultList();
    }


}

package com.springboot.medicinereminder.Repositories;

import com.springboot.medicinereminder.models.Duration;
import com.springboot.medicinereminder.models.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medicine, Integer> {
    Medicine findByName(String name);
    void deleteByName(String name);

    Medicine findByDuration(Duration existingDuration);
}

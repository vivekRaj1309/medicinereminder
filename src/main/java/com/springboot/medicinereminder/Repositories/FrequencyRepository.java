package com.springboot.medicinereminder.Repositories;

import com.springboot.medicinereminder.models.Frequency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
@Repository
public interface FrequencyRepository extends JpaRepository<Frequency, Integer> {
    Frequency findByTime(LocalTime localTime);
}

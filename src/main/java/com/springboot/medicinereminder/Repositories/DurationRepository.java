package com.springboot.medicinereminder.Repositories;

import com.springboot.medicinereminder.models.Duration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DurationRepository extends JpaRepository<Duration, Integer> {
    Duration findByStartDateAndEndDate(Date startDate, Date endDate);
}

package com.springboot.medicinereminder.service;

import com.springboot.medicinereminder.Repositories.DurationRepository;
import com.springboot.medicinereminder.models.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DurationService {
    @Autowired
    private DurationRepository durationRepository;
    public Duration addNewDuration(Date startDate, Date endDate) {
        Duration existingDuration = durationRepository.findByStartDateAndEndDate(startDate, endDate);
        if(existingDuration == null){
            Duration newDuration = new Duration();
            newDuration.setStartDate(startDate);
            newDuration.setEndDate(endDate);
            existingDuration = durationRepository.save(newDuration);
        }
        return existingDuration;
    }
}

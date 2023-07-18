package com.springboot.medicinereminder.service;

import com.springboot.medicinereminder.Repositories.FrequencyRepository;
import com.springboot.medicinereminder.models.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FrequencyService {
    @Autowired
    FrequencyRepository frequencyRepository;
    public List<Frequency> addNewFrequency(List<LocalTime> timeList) {
        List<Frequency> frequencyList = new ArrayList<>();
        for(LocalTime localTime : timeList){
            Frequency existingFrequency = frequencyRepository.findByTime(localTime);
            if(existingFrequency == null){
                Frequency frequency = new Frequency();
                frequency.setTime(localTime);
                existingFrequency = frequencyRepository.save(frequency);
            }
            frequencyList.add(existingFrequency);
        }
        return frequencyList;
    }
}

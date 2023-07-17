package com.springboot.medicinereminder.Scheduler;

import com.springboot.medicinereminder.Repositories.FrequencyRepository;
import com.springboot.medicinereminder.models.Frequency;
import com.springboot.medicinereminder.models.Medicine;
import com.springboot.medicinereminder.service.TwilioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@EnableScheduling
public class MedicationFrequencyScheduler {
    @Autowired
    FrequencyRepository frequencyRepository;
    @Autowired
    TwilioService twilioService;
    @Transactional
    @Scheduled(cron = "0 * * * * *")
    public void sendMedicineReminder(){
        LocalTime now = LocalTime.now().withSecond(0).withNano(0);
        Frequency currFrequency = frequencyRepository.findByTime(now);
        if(currFrequency != null){
            StringBuilder messageBuilder = new StringBuilder("Reminder: Take the following medicines: ");
            List<Medicine> medicineList = currFrequency.getMedicines();
            Set<Medicine> medicines = new HashSet<>(medicineList);
            for(Medicine medicine:medicines){
                messageBuilder.append(medicine.getName() + " ");
            }
            twilioService.sendSms("+919162018811", messageBuilder.toString());
        }
    }
}

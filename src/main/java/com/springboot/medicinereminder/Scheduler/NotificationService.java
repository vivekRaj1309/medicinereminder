package com.springboot.medicinereminder.Scheduler;

import com.springboot.medicinereminder.Repositories.FrequencyRepository;

import com.springboot.medicinereminder.Repositories.UserRepository;
import com.springboot.medicinereminder.models.Frequency;
import com.springboot.medicinereminder.models.Medicine;
import com.springboot.medicinereminder.models.User;
import com.springboot.medicinereminder.service.StockService;
import com.springboot.medicinereminder.service.TwilioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
@EnableScheduling
public class NotificationService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    StockService stockService;
    @Autowired
    FrequencyRepository frequencyRepository;
    @Autowired
    TwilioService twilioService;
    User user = new User();
    @Transactional
    @Scheduled(cron = "0 * * * * *")
    public void sendMedicineReminder(){
        user = userRepository.findById(1);
        LocalTime now = LocalTime.now().withSecond(0).withNano(0);
        Frequency currFrequency = frequencyRepository.findByTime(now);
        System.out.println(now);
        if(currFrequency != null){
            StringBuilder messageBuilder = new StringBuilder("Reminder: Take the following medicines: ");
            List<Medicine> medicineList = currFrequency.getMedicines();
            for(Medicine medicine:medicineList){
                System.out.println(medicine.getDuration().getStartDate());
                messageBuilder.append(medicine.getName() + " : " + medicine.getDosage() + ", ");
                int currStock = medicine.getStock().getValue();
                if(currStock < 10){
                    twilioService.sendSms(user.getContact(), "Kindly refill/restock "
                            + medicine.getName() + ". Current availability: " + currStock + " pills.");
                } else if (currStock > 0) {
                    int newStock = currStock-medicine.getDosage();
                    stockService.updateStock(currStock, newStock, medicine);
                }
            }
            twilioService.sendSms(user.getContact(), messageBuilder.toString());
        }
    }
}

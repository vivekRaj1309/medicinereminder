package com.springboot.medicinereminder.service;

import com.springboot.medicinereminder.Repositories.StockRepository;
import com.springboot.medicinereminder.models.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;

    public Stock addNewStock(int stockValue) {
        Stock existingStock = stockRepository.findByValue(stockValue);
        if(existingStock == null){
            Stock stock = new Stock();
            stock.setValue(stockValue);
            existingStock = stockRepository.save(stock);
        }
        return existingStock;
    }
}

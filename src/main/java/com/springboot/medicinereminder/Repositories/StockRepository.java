package com.springboot.medicinereminder.Repositories;

import com.springboot.medicinereminder.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findByValue(int stockValue);
}

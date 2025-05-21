package com.codegym.service;

import com.codegym.model.Promotion;
import com.codegym.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Optional<Promotion> getPromotionById(Long id) {
        return promotionRepository.findById(id);
    }

    public void savePromotion(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }

    public List<Promotion> searchByDiscount(Integer discount) {
        return promotionRepository.findByDiscount(discount);
    }

    public List<Promotion> searchByStartDate(LocalDate startDate) {
        return promotionRepository.findByStartDate(startDate);
    }

    public List<Promotion> searchByEndDate(LocalDate endDate) {
        return promotionRepository.findByEndDate(endDate);
    }

    public List<Promotion> searchByAllConditions(Integer discount, LocalDate startDate, LocalDate endDate) {
        return promotionRepository.findByDiscountAndStartDateAndEndDate(discount, startDate, endDate);
    }
}
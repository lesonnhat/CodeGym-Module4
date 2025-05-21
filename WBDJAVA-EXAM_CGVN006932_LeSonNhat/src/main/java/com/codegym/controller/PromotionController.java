package com.codegym.controller;

import com.codegym.model.Promotion;
import com.codegym.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping
    public String listPromotions(Model model,
                                 @RequestParam(required = false) Integer discount,
                                 @RequestParam(required = false) String startDate,
                                 @RequestParam(required = false) String endDate) {
        List<Promotion> promotions;

        LocalDate parsedStartDate = startDate != null && !startDate.isEmpty() ? LocalDate.parse(startDate) : null;
        LocalDate parsedEndDate = endDate != null && !endDate.isEmpty() ? LocalDate.parse(endDate) : null;

        if (discount != null || parsedStartDate != null || parsedEndDate != null) {
            promotions = promotionService.searchByAllConditions(discount, parsedStartDate, parsedEndDate);
        } else {
            promotions = promotionService.getAllPromotions();
        }

        model.addAttribute("promotions", promotions);
        return "promotions/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("promotion", new Promotion());
        return "promotions/create";
    }

    @PostMapping("/create")
    public String createPromotion(@Valid @ModelAttribute Promotion promotion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "promotions/create";
        }

        LocalDate today = LocalDate.now();
        if (promotion.getStartDate() != null && promotion.getStartDate().isBefore(today)) {
            result.rejectValue("startDate", "error.startDate", "Thời gian bắt đầu phải lớn hơn thời gian hiện tại");
            return "promotions/create";
        }

        if (promotion.getStartDate() != null && promotion.getEndDate() != null &&
                !promotion.getEndDate().isAfter(promotion.getStartDate())) {
            result.rejectValue("endDate", "error.endDate", "Thời gian kết thúc phải lớn hơn thời gian bắt đầu ít nhất 1 ngày");
            return "promotions/create";
        }

        promotionService.savePromotion(promotion);
        return "redirect:/promotions";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Promotion> promotion = promotionService.getPromotionById(id);
        if (promotion.isPresent()) {
            model.addAttribute("promotion", promotion.get());
            return "promotions/edit";
        } else {
            return "redirect:/promotions";
        }
    }

    @PostMapping("/{id}/edit")
    public String updatePromotion(@PathVariable Long id, @Valid @ModelAttribute Promotion promotion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "promotions/edit";
        }

        LocalDate today = LocalDate.now();
        if (promotion.getStartDate() != null && promotion.getStartDate().isBefore(today)) {
            result.rejectValue("startDate", "error.startDate", "Thời gian bắt đầu phải lớn hơn thời gian hiện tại");
            return "promotions/edit";
        }

        if (promotion.getStartDate() != null && promotion.getEndDate() != null &&
                !promotion.getEndDate().isAfter(promotion.getStartDate())) {
            result.rejectValue("endDate", "error.endDate", "Thời gian kết thúc phải lớn hơn thời gian bắt đầu ít nhất 1 ngày");
            return "promotions/edit";
        }

        promotion.setId(id);
        promotionService.savePromotion(promotion);
        return "redirect:/promotions";
    }

    @GetMapping("/{id}/delete")
    public String deletePromotion(@PathVariable Long id) {
        promotionService.deletePromotion(id);
        return "redirect:/promotions";
    }
}
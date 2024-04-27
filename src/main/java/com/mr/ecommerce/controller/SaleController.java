package com.mr.ecommerce.controller;

import com.mr.ecommerce.service.SalesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api/sales")
public class SaleController {


    private final SalesService saleService;

    @Autowired
    public SaleController(SalesService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/v1/today/total-amount")
    @Operation(description = "API to return the total sale amount of the current day.")
    public ResponseEntity<Double> getTotalSaleAmountToday() {
        double totalAmount = saleService.getTotalSaleAmountToday();
        return ResponseEntity.ok(totalAmount);
    }

    @GetMapping("/v1/max-sale-day")
    @Operation(description = "API to return the max sale day of a certain time range.")
    public ResponseEntity<Date> getMaxSaleDay(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Date maxSaleDay = saleService.getMaxSaleDay(startDate, endDate);
        return ResponseEntity.ok(maxSaleDay);
    }
}

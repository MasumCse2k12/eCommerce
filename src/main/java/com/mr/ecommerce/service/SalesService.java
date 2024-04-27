package com.mr.ecommerce.service;

import java.time.LocalDate;
import java.util.Date;

public interface SalesService {
    double getTotalSaleAmountToday();

    Date getMaxSaleDay(LocalDate startDate, LocalDate endDate);
}

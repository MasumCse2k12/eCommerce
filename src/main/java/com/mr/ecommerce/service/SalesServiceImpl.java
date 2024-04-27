package com.mr.ecommerce.service;

import com.mr.ecommerce.repository.SalesRepository;
import com.mr.ecommerce.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
@Slf4j
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;

    @Autowired
    public SalesServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }


    @Override
    public double getTotalSaleAmountToday() {
        LocalDate today = LocalDate.now();
        log.info("Total sales amount filter by today : {}" , today);
        return salesRepository.getTotalSaleAmountByDate(CommonUtils.localDateToDate(today));
    }

    @Override
    public Date getMaxSaleDay(LocalDate startDate, LocalDate endDate) {
        log.info("Max sale day date range,  start date :: {}, end date :: {}", startDate, endDate);
        return salesRepository.getMaxSaleDay(CommonUtils.localDateToDate(startDate),
                CommonUtils.localDateToDate(endDate));
    }
}

package com.mr.ecommerce.controller;

import com.mr.ecommerce.service.SalesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SaleController.class)
public class SaleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalesService saleService;

    @Test
    public void testGetTotalSaleAmountToday_Success() throws Exception {
        // Mock total sale amount for the current day
        double totalSaleAmount = 1000.0;

        // Mock saleService to return total sale amount
        when(saleService.getTotalSaleAmountToday()).thenReturn(totalSaleAmount);

        // Perform GET request to total sale amount endpoint
        mockMvc.perform(get("/api/sales/v1/today/total-amount"))
                .andExpect(status().isOk());
    }


    @Test
    public void testGetMaxSaleDay_Success() throws Exception {
        // Mock max sale day within date range
        Date maxSaleDay = new Date();

        // Mock saleService to return max sale day
        when(saleService.getMaxSaleDay(any(LocalDate.class), any(LocalDate.class))).thenReturn(maxSaleDay);

        // Perform GET request to max sale day endpoint with date range parameters
        mockMvc.perform(get("/api/sales/v1/max-sale-day")
                        .param("startDate", "2024-04-01")
                        .param("endDate", "2024-04-30"))
                .andExpect(status().isOk());
    }
}


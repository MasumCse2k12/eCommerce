package com.mr.ecommerce.controller;

import com.mr.ecommerce.error.ResourceNotFoundException;
import com.mr.ecommerce.payload.ProductDto;
import com.mr.ecommerce.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void testGetWishlist_Success() throws Exception {
        // Mock customer's wish list
        List<ProductDto> wishlist = new ArrayList<>();
        wishlist.add(new ProductDto("Product 1", BigDecimal.valueOf(30), "Sample P1"));
        wishlist.add(new ProductDto("Product 2", BigDecimal.valueOf(20.50), "Sample P2"));
        wishlist.add(new ProductDto("Product 3", BigDecimal.valueOf(50), "Sample P3"));

        // Mock customerService to return wish list
        when(customerService.getWishlist(anyInt())).thenReturn(wishlist);

        // Perform GET request to wish list endpoint
        mockMvc.perform(get("/api/customers/v1/1/wishlist"))
                .andExpect(status().isOk());
    }


    @Test
    public void testGetWishlist_CustomerNotFound() throws Exception {
        // Mock customerService to throw ResourceNotFoundException
        when(customerService.getWishlist(anyInt())).thenThrow(new ResourceNotFoundException("Customer not found"));

        // Perform GET request to wish list endpoint
        mockMvc.perform(get("/api/customers/v1/1/wishlist"))
                .andExpect(status().isNotFound());
    }
}

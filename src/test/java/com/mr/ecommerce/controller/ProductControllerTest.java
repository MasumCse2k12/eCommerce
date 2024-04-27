package com.mr.ecommerce.controller;

import com.mr.ecommerce.payload.ProductDto;
import com.mr.ecommerce.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testGetTopSellingProducts_Success() throws Exception {
        // Mock top-selling products
        List<ProductDto> topSellingProducts = new ArrayList<>();
        topSellingProducts.add(new ProductDto("Product 1", BigDecimal.valueOf(30), "Sample P1"));
        topSellingProducts.add(new ProductDto("Product 2", BigDecimal.valueOf(20.50), "Sample P2"));
        topSellingProducts.add(new ProductDto("Product 3", BigDecimal.valueOf(50), "Sample P3"));

        // Mock productService to return top-selling products
        when(productService.getTopSellingProducts()).thenReturn(topSellingProducts);

        // Perform GET request to top-selling products endpoint
        mockMvc.perform(get("/api/products/v1/top-selling"))
                .andExpect(status().isOk());
    }
}


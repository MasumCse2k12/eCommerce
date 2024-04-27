package com.mr.ecommerce.controller;

import com.mr.ecommerce.payload.ProductDto;
import com.mr.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieves the wish list of a customer.
     *
     * @return ResponseEntity containing the top-selling products by total sale amount all the times if found.
     */
    @Operation(description = "Retrieves the top selling products by total sale amount all the times.")
    @GetMapping("/v1/top-selling")
    public ResponseEntity<List<ProductDto>> getTopSellingProducts() {
        List<ProductDto> topSellingProducts = productService.getTopSellingProducts();
        return ResponseEntity.ok(topSellingProducts);
    }

    /**
     * Retrieves the wish list of a customer.
     *
     * @return ResponseEntity containing the last month top-selling products if found.
     */
    @GetMapping("/v1/top-selling-last-month")
    @Operation(description = "Retrieves the last month top selling products.")
    public ResponseEntity<List<ProductDto>> getTopSellingProductsLastMonth() {
        List<ProductDto> topSellingProductsLastMonth = productService.getTopSellingProductsLastMonth();
        return ResponseEntity.ok(topSellingProductsLastMonth);
    }
}

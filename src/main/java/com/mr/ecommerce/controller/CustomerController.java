package com.mr.ecommerce.controller;

import com.mr.ecommerce.payload.ProductDto;
import com.mr.ecommerce.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    /**
     * Retrieves the wish list of a customer.
     *
     * @param customerId The ID of the customer whose wish list is to be retrieved.
     * @return ResponseEntity containing the wish list of the customer if found.
     */
    @GetMapping("/v1/{customerId}/wishlist")
    @Operation(description = "Retrieves the wish list of a customer.")
    public ResponseEntity<List<ProductDto>> getWishlist(@PathVariable Integer customerId) {
        List<ProductDto> wishlist = customerService.getWishlist(customerId);
        return ResponseEntity.ok(wishlist);
    }
}

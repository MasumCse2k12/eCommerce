package com.mr.ecommerce.service;

import com.mr.ecommerce.payload.ProductDto;

import java.util.List;

public interface CustomerService {
    public List<ProductDto> getWishlist(Integer customerId);
}

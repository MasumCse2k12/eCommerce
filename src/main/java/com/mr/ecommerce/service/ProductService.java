package com.mr.ecommerce.service;

import com.mr.ecommerce.model.ProductEntity;
import com.mr.ecommerce.payload.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getTopSellingProducts();
    List<ProductDto> getTopSellingProductsLastMonth();
}

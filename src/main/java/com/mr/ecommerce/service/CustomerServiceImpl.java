package com.mr.ecommerce.service;

import com.mr.ecommerce.error.ResourceNotFoundException;
import com.mr.ecommerce.model.CustomerEntity;
import com.mr.ecommerce.payload.ProductDto;
import com.mr.ecommerce.repository.CustomerRepository;
import com.mr.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getWishlist(Integer customerId) {
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
        return productRepository.findAllProductsByCustomerId(customerId);
    }
}

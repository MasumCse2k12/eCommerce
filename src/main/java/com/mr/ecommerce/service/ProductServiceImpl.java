package com.mr.ecommerce.service;

import com.mr.ecommerce.model.ProductEntity;
import com.mr.ecommerce.payload.ProductDto;
import com.mr.ecommerce.repository.ProductRepository;
import com.mr.ecommerce.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getTopSellingProducts() {
        List<ProductEntity> productEntityList = productRepository.findTop5ItemsByTotalSalesAmount();
        return productEntityList.stream().map(this::convertProductEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getTopSellingProductsLastMonth() {

        LocalDate startDate = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        log.info("Last month start date : {} ", startDate);

        LocalDate endDate = LocalDate.now().minusMonths(1).withDayOfMonth(
                YearMonth.of(LocalDate.now().minusMonths(1).getYear(),
                        LocalDate.now().minusMonths(1).getMonth()).lengthOfMonth());
        log.info("Last month EndDate : {}", endDate);

        List<ProductEntity> productEntityList = productRepository.findLastMonthTop5ItemsBySaleQuantity(
                CommonUtils.localDateToDate(startDate), CommonUtils.localDateToDate(endDate));

        return productEntityList.stream().map(this::convertProductEntityToDto).collect(Collectors.toList());
    }

    private ProductDto convertProductEntityToDto(ProductEntity  productEntity) {
        return ProductDto.builder()
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .description(productEntity.getDescription())
                .build();
    }
}

package com.mr.ecommerce.repository;

import com.mr.ecommerce.model.ProductEntity;
import com.mr.ecommerce.payload.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query("SELECT com.mr.ecommerce.payload.ProductDto(pe.name, pe.price, pe.description) " +
            " FROM ProductEntity pe WHERE pe.id in " +
            "  (select oie.productId from OrderItemEntity oie" +
            "   left join OrderEntity oe on oe.id = oie.orderId" +
            "   where oe.customerId = :customerId) ")
    List<ProductDto> findAllProductsByCustomerId(Integer customerId);

    @Query("SELECT pe FROM ProductEntity pe " +
            " INNER JOIN SalesEntity se on se.productId = pe.id " +
            " ORDER BY se.amount DESC LIMIT 5")
    List<ProductEntity> findTop5ItemsByTotalSalesAmount();

    @Query("SELECT pe FROM ProductEntity pe " +
            " INNER JOIN OrderItemEntity oie on oie.productId = pe.id " +
            " INNER JOIN OrderEntity oe on oie.orderId = oe.id " +
            " INNER JOIN SalesEntity se on se.productId = pe.id " +
            "   WHERE se.saleDate >= :startDate " +
            "   and se.saleDate <= :saleDate " +
            " ORDER BY oie.quantity DESC LIMIT 5")
    List<ProductEntity> findLastMonthTop5ItemsBySaleQuantity(Date startDate, Date endDate);
}

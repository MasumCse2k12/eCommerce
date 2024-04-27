package com.mr.ecommerce.repository;

import com.mr.ecommerce.model.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SalesRepository extends JpaRepository<SalesEntity, Integer> {

    @Query("SELECT COALESCE(SUM(s.amount), 0) FROM SalesEntity s WHERE s.saleDate = :date")
    double getTotalSaleAmountByDate(@Param("date") Date date);

    @Query("SELECT s.saleDate FROM SalesEntity s " +
            " WHERE s.saleDate BETWEEN :startDate AND :endDate " +
            " GROUP BY s.saleDate ORDER BY COUNT(s.saleDate) DESC LIMIT 1 ")
    Date getMaxSaleDay(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}

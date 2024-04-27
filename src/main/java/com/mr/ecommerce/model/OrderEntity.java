package com.mr.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "e_order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseEntity{

    @Column(name = "customer_id", nullable = false)
    Integer customerId;
    @Column(name = "order_date")
    Date orderDate;
}

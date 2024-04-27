package com.mr.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "order_item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalesEntity extends BaseEntity {
    @Column(name = "product_id", nullable = false)
    Integer productId;
    @Column(name = "sale_date")
    Date saleDate;
    @Column(name = "amount", nullable = false)
    BigDecimal amount;
}

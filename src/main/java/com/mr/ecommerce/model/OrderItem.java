package com.mr.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "order_item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItem extends BaseEntity {

    @Column(name = "order_id", nullable = false)
    Integer orderId;
    @Column(name = "product_id", nullable = false)
    Integer productId;
    @Column(name = "quantity", nullable = false)
    Integer quantity;
}

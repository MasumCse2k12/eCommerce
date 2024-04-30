package com.mr.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "price", nullable = false)
    BigDecimal price;
    @Column(name = "description")
    String description;
}

package com.mr.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String contact;
}


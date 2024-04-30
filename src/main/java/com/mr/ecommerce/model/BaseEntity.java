package com.mr.ecommerce.model;

import com.mr.ecommerce.util.enums.DbEntrySatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    @SequenceGenerator(name = "id", sequenceName = "id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "row_status", nullable = false)
    DbEntrySatus rowStatus = DbEntrySatus.ACTIVE;
}

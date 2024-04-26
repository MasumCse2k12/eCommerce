package com.mr.ecommerce.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class BaseDomain implements Serializable {
    Date created;
    Date updated;
    long version;

    @PrePersist
    protected void onCreate() {
        this.created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated = new Date();
    }

    @Version
    @Access(AccessType.PROPERTY)
    public long getVersion() {
        return this.version;
    }
}

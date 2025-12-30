package com.springsecurex.spring_securex.utility.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseAuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_at", nullable = false)
    private OffsetDateTime modifiedAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "is_active", nullable = false)
    private Boolean active;

    @PrePersist
    protected void onCreate(){
        OffsetDateTime now = OffsetDateTime.now();
        this.createdAt = now;
        this.modifiedAt = now;
        this.active = true;
        this.createdBy = "SYSTEM";
        this.modifiedBy = "SYSTEM";
    }

    @PreUpdate
    protected void onUpdate(){
        this.modifiedAt = OffsetDateTime.now();
        this.modifiedBy = "SYSTEM";
    }
}

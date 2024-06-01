package com.app.GroupMatching.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Getter @Setter
public class BaseEntity {

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @PrePersist
    public void setCreatedAt(){
        createdAt = LocalDate.now();
    }
}

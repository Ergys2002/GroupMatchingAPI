package com.app.GroupMatching.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "interests")
@Getter @Setter
public class Interest extends BaseEntity{
    private String title;
}

package com.app.GroupMatching.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "interests")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Interest extends BaseEntity{
    private String title;
}

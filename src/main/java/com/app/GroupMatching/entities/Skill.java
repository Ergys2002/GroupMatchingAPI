package com.app.GroupMatching.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skill extends BaseEntity{
    private String title;

}

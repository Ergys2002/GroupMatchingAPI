package com.app.GroupMatching.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "languages")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Language extends BaseEntity{
    private String title;


}

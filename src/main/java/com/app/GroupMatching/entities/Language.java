package com.app.GroupMatching.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "languages")
@Getter @Setter
public class Language extends BaseEntity{
    private String title;


}

package com.app.GroupMatching.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "group_languages")
@Getter @Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class GroupLanguage extends BaseEntity{
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "language_id" , referencedColumnName = "id")
    private Language language;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "group_id" , referencedColumnName = "id")
    private Group group;
}

package com.app.GroupMatching.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "group_languages")
@Getter @Setter
public class GroupLanguage extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "language_id" , referencedColumnName = "id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "group_id" , referencedColumnName = "id")
    private Group group;
}

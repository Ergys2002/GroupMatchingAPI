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
@Table(name = "group_skills")
@Getter @Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class GroupSkill extends BaseEntity{
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "group_id" , referencedColumnName = "id")
    private Group group;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private Skill skill;
}

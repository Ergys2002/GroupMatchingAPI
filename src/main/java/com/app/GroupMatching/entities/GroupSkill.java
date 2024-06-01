package com.app.GroupMatching.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "group_skills")
@Getter @Setter
public class GroupSkill extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "group_id" , referencedColumnName = "id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private Skill skill;
}

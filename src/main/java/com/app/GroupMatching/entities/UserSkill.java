package com.app.GroupMatching.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_skills")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSkill extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "skill_id" ,referencedColumnName = "id")
    private Skill skill;
}

package com.app.GroupMatching.entities;

import com.app.GroupMatching.enums.GroupStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "_groups")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private GroupStatus status;

    @ManyToOne
    @JoinColumn(name = "leader_id", referencedColumnName = "id")
    private User leader;

    @OneToMany(mappedBy = "group")
    private Set<GroupMember> groupMembers;

    @OneToMany(mappedBy = "group")
    private Set<GroupLanguage> groupLanguages;

    @OneToMany(mappedBy = "group")
    private Set<GroupSkill> groupSkills;

    @OneToMany(mappedBy = "group")
    private Set<GroupMessage> messages;

    @OneToMany(mappedBy = "group")
    private Set<Match> matches;

    private int capacity;
    private String title;
    @Column(name = "logo_url")
    private String logoURL;

}

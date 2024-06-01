package com.app.GroupMatching.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "group_members")
public class GroupMember extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "member_id" , referencedColumnName = "id")
    private User member;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

}

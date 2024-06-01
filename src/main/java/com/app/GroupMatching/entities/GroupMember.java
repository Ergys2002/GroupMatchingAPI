package com.app.GroupMatching.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "group_members")
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class GroupMember extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "member_id" , referencedColumnName = "id")
    private User member;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @JsonBackReference
    private Group group;

}

package com.app.GroupMatching.entities;

import com.app.GroupMatching.enums.GroupJoinApplicationStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "group_join_applications")
public class GroupJoinApplication extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    private User applicant;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;
    @Enumerated(EnumType.STRING)
    private GroupJoinApplicationStatus status;
}

package com.app.GroupMatching.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter
public class User extends BaseEntity{

    private String email;
    private String password;
    private String name;
    private String lastname;
    private String position;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private int likes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserSkill> skills;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserInterest> interests;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserLanguage> languages;

    @OneToMany(mappedBy = "sender")
    private Set<Notification> notificationsSent;

    @OneToMany(mappedBy = "recipient")
    private Set<Notification> notificationsReceived;

    @OneToMany(mappedBy = "leader")
    private Set<Group> groups;

    @OneToMany(mappedBy = "member")
    private Set<GroupMember> participations;

    @OneToMany(mappedBy = "sender")
    private Set<PrivateMessage> privateMessagesSent;

    @OneToMany(mappedBy = "receiver")
    private Set<PrivateMessage> privateMessagesReceived;

    @OneToMany(mappedBy = "sender")
    private Set<GroupMessage> groupMessagesSent;

    @OneToMany(mappedBy = "user")
    private Set<Match> matches;
}

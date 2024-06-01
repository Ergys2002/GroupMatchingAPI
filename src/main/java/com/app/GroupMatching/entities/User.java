package com.app.GroupMatching.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements UserDetails {

    private String email;
    private String password;
    private String name;
    private String lastname;
    private String position;
    @Column(name = "phone_number")
    private String phoneNumber;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

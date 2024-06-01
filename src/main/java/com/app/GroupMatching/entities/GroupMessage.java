package com.app.GroupMatching.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "group_messages")
public class GroupMessage extends Message{
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;
    private String content;
}

package com.app.GroupMatching.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "private_messages")
public class PrivateMessage extends Message{

    @ManyToOne
    @JoinColumn(name = "receiver_id" , referencedColumnName = "id")
    private User receiver;
    private String content;
}

package com.amr.project.model.entity_refactor;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<User> members;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Message> messages;

    private Long hash;

}

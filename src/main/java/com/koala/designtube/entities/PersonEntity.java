package com.koala.designtube.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person", catalog = "designtube")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    // Relationships

    @ManyToOne
    private RoleEntity role;

    @OneToMany(mappedBy = "author")
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "owner")
    private List<ChannelEntity> ownedChannels;

    @ManyToMany(mappedBy = "subscribers")
    private List<ChannelEntity> subscribedChannels;
}

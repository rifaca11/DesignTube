package com.koala.designtube.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class CommentEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String contenu;

        @ManyToOne
        private UserEntity auteur;

        @ManyToOne
        private VedioEntity video;

}

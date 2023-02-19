package com.koala.designtube.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@Data
public class VedioEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String titre;
        private String url;

        @ManyToOne
        private ModeratorEntity auteur;

        private Date dateAjout;

        @ElementCollection
        @CollectionTable(name = "video_reactions")
        @MapKeyColumn(name = "reaction")
        @Column(name = "count")
        private Map<String, Integer> reactions;

        @OneToMany(mappedBy = "video")
        private List<CommentEntity> commentaires;

    }

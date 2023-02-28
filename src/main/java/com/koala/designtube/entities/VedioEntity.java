package com.koala.designtube.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vedio", catalog = "designtube")
public class VedioEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        private String description;

        private String url;

        private Date uploadDate;

        private int views;

        private int likes;

        private int dislikes;

        @ElementCollection
        private List<String> tags;

        // Relationships

        @OneToMany(mappedBy = "video")
        private List<CommentEntity> comments;

        @ManyToOne
        private ChannelEntity channel;

        @ManyToOne
        private PlaylistEntity playlist;

}

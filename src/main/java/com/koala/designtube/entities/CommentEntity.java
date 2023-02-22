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
@Table(name = "comment", catalog = "designtube")
public class CommentEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String text;
        private int likes;
        private int dislikes;
        private Date date;

        @ManyToOne
        private PersonEntity author;

        @ManyToOne
        private VedioEntity video;

        @ManyToOne
        private CommentEntity replyTo;

        @OneToMany(mappedBy = "replyTo")
        private List<CommentEntity> replies;


}




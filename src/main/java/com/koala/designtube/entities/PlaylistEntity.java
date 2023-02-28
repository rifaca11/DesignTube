package com.koala.designtube.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "playlist", catalog = "designtube")
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @OneToMany(mappedBy = "playlists", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChannelEntity> channels = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "playlist_videos",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "video_id"))
    private List<VedioEntity> videos = new ArrayList<>();

}
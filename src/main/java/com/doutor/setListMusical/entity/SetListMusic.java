package com.doutor.setListMusical.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "set_list_music")
@NoArgsConstructor
@Getter
@Setter
public class SetListMusic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private Long sequence;
    private String description;
    @ManyToOne
    private Music music;

    @Builder
    public SetListMusic(Long sequence, String description, Music music) {
        this.sequence = sequence;
        this.description = description;
        this.music = music;
    }
}

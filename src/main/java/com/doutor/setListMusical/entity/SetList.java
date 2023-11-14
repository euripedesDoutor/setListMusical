package com.doutor.setListMusical.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "set_list")
@NoArgsConstructor
@Getter
@Setter
public class SetList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    @ManyToOne
    private User userRegister;
    @OneToMany
    private List<Tag> listTag;
    @OneToMany
    private List<SetListMusic> listMusic;

    @Builder
    public SetList(String name, User userRegister, List<Tag> listTag, List<SetListMusic> listMusic) {
        this.name = name;
        this.userRegister = userRegister;
        this.listTag = listTag;
        this.listMusic = listMusic;
    }
}

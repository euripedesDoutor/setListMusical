package com.doutor.setListMusical.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "musical_group")
@NoArgsConstructor
@Getter
@Setter
public class MusicalGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private byte[] image;
    @OneToMany
    private List<User> listMember;

    @Builder
    public MusicalGroup(String name, byte[] image, List<User> listMember) {
        this.name = name;
        this.image = image;
        this.listMember = listMember;
    }
}
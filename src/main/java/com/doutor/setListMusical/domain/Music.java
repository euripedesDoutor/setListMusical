package com.doutor.setListMusical.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "music")
@NoArgsConstructor
@Getter
@Setter
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @ManyToOne
    private User userRegister;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegister;
    private String letter;
    private String cipher;
    private String link;
    @OneToMany
    private List<Tag> listTag;
    @OneToMany
    private List<MusicAttachment> listAttachment;

    @Builder
    public Music(String name, User userRegister, Date dataRegister, String letter, String cipher, String link, List<Tag> listTag, List<MusicAttachment> listAttachment) {
        this.name = name;
        this.userRegister = userRegister;
        this.dataRegister = dataRegister;
        this.letter = letter;
        this.cipher = cipher;
        this.link = link;
        this.listTag = listTag;
        this.listAttachment = listAttachment;
    }
}

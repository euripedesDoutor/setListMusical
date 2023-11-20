package com.doutor.setListMusical.domain;

import com.doutor.setListMusical.domain.enumEntity.TypeAttachmentEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "music_attachment")
@NoArgsConstructor
@Getter
@Setter
public class MusicAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private byte[] document;
    @Enumerated(EnumType.STRING)
    private TypeAttachmentEnum typeAttachment;
}

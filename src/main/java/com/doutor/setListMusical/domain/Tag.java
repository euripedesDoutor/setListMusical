package com.doutor.setListMusical.domain;

import com.doutor.setListMusical.domain.enumEntity.TypeTagEnum;
import com.doutor.setListMusical.dtos.TagDTO;
import com.doutor.setListMusical.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tag")
@NoArgsConstructor
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private TypeTagEnum typeTag;
    private String name;
    private String acronym;

    @Builder
    public Tag(TypeTagEnum typeTag, String name, String acronym) {
        this.typeTag = typeTag;
        this.name = name;
        this.acronym = acronym;
    }

    public Tag(TagDTO tagDto) {
        this.name = tagDto.name();
        this.acronym = tagDto.acronym();
        this.typeTag = tagDto.typeTag();
    }
}

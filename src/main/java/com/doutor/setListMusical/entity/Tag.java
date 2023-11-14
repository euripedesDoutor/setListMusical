package com.doutor.setListMusical.entity;

import com.doutor.setListMusical.entity.enumEntity.TypeTagEnum;
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

    @Builder
    public Tag(TypeTagEnum typeTag, String name) {
        this.typeTag = typeTag;
        this.name = name;
    }
}

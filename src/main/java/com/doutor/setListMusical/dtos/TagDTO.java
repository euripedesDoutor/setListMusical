package com.doutor.setListMusical.dtos;

import com.doutor.setListMusical.domain.enumEntity.TypeTagEnum;

public record TagDTO(String name, TypeTagEnum typeTag, String acronym) {
}

package com.doutor.setListMusical.services;

import com.doutor.setListMusical.domain.Tag;
import com.doutor.setListMusical.domain.enumEntity.TypeTagEnum;
import com.doutor.setListMusical.dtos.TagDTO;

import java.util.List;

public interface TagService {

    Tag findById(Long id);

    Tag findByName(String name);

    Tag findByAcronym(String acronym);

    Tag findByTypeTag(TypeTagEnum typeTag);

    List<Tag> findAll();

    Tag register(TagDTO tagDTO);

    Tag update(TagDTO tagDTO, Long id);

    String delete(Long id);
}

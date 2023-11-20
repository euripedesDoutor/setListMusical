package com.doutor.setListMusical.repositories;

import com.doutor.setListMusical.domain.Tag;
import com.doutor.setListMusical.domain.enumEntity.TypeTagEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByName(String name);

    Tag findByAcronym(String acronym);

    Tag findByTypeTag(TypeTagEnum typeTag);
}

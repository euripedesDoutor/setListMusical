package com.doutor.setListMusical.repositories;

import com.doutor.setListMusical.domain.MusicAttachment;
import com.doutor.setListMusical.domain.Tag;
import com.doutor.setListMusical.domain.enumEntity.TypeAttachmentEnum;
import com.doutor.setListMusical.domain.enumEntity.TypeTagEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicAttachmentRepository extends JpaRepository<MusicAttachment, Long> {

    MusicAttachment findByTypeAttachment(TypeAttachmentEnum typeAttachment);

    MusicAttachment findByMusic(Long music);

}

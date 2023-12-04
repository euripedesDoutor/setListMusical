package com.doutor.setListMusical.services;

import com.doutor.setListMusical.domain.MusicAttachment;
import com.doutor.setListMusical.domain.Tag;
import com.doutor.setListMusical.domain.enumEntity.TypeAttachmentEnum;
import com.doutor.setListMusical.dtos.MusicAttachmentDTO;

import java.util.List;

public interface MusicAttachmentService {

    MusicAttachment findById(Long id);

    MusicAttachment findByMusic(Long music);

    MusicAttachment findByTypeAttachment(TypeAttachmentEnum typeAttachment);

    List<MusicAttachment> findAll();

    MusicAttachment register(MusicAttachmentDTO musicAttachmentDTO);

    MusicAttachment update(MusicAttachmentDTO musicAttachmentDTO, Long id);

    String delete(Long id);
}

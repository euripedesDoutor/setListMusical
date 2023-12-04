package com.doutor.setListMusical.dtos;

import com.doutor.setListMusical.domain.enumEntity.TypeAttachmentEnum;

public record MusicAttachmentDTO(byte[] document, TypeAttachmentEnum typeAttachment) {
}

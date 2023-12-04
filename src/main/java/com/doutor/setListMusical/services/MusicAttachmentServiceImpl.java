package com.doutor.setListMusical.services;

import com.doutor.setListMusical.domain.MusicAttachment;
import com.doutor.setListMusical.domain.enumEntity.TypeAttachmentEnum;
import com.doutor.setListMusical.dtos.MusicAttachmentDTO;
import com.doutor.setListMusical.repositories.MusicAttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class MusicAttachmentServiceImpl implements MusicAttachmentService {

    private final MusicAttachmentRepository musicAttachmentRepository;

    @Override
    public MusicAttachment findById(Long id) {
        return returnMusicAttachment(id);
    }

    @Override
    public MusicAttachment findByMusic(Long music) {
        return returnMusicAttachment(music);
    }

    @Override
    public MusicAttachment findByTypeAttachment(TypeAttachmentEnum typeAttachment) {
        return musicAttachmentRepository.findByTypeAttachment(typeAttachment);
    }

    @Override
    public List<MusicAttachment> findAll() {
        return musicAttachmentRepository.findAll();
    }

    @Override
    public MusicAttachment register(MusicAttachmentDTO musicAttachmentDTO) {
        MusicAttachment musicAttachment = new MusicAttachment(musicAttachmentDTO);
        musicAttachment = musicAttachmentRepository.save(musicAttachment);
        return musicAttachment;
    }

    @Override
    public MusicAttachment update(MusicAttachmentDTO musicAttachmentDTO, Long id) {
        MusicAttachment musicAttachment = returnMusicAttachment(id);
        musicAttachment = loadData(musicAttachment, musicAttachmentDTO);
        return musicAttachmentRepository.save(musicAttachment);
    }

    @Override
    public String delete(Long id) {
        musicAttachmentRepository.deleteById(id);
        return "MusicAttachment ID: " + id + " deleted";
    }

    private MusicAttachment returnMusicAttachment(Long id) {
        return musicAttachmentRepository.findById(id).orElseThrow(() -> new RuntimeException("MusicAttachment wasn't found on database"));
    }

    private MusicAttachment loadData(MusicAttachment musicAttachment, MusicAttachmentDTO musicAttachmentDTO){
        musicAttachment.setDocument(musicAttachmentDTO.document());
        musicAttachment.setTypeAttachment(musicAttachmentDTO.typeAttachment());
        return musicAttachment;
    }
}

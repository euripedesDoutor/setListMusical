package com.doutor.setListMusical.controllers;

import com.doutor.setListMusical.domain.MusicAttachment;
import com.doutor.setListMusical.domain.enumEntity.TypeAttachmentEnum;
import com.doutor.setListMusical.dtos.MusicAttachmentDTO;
import com.doutor.setListMusical.services.MusicAttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/m usicAttachment")
@RequiredArgsConstructor
public class MusicAttachmentController {
    private final MusicAttachmentService musicAttachmentService;

    @GetMapping("/{id}")
    public ResponseEntity<MusicAttachment> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(musicAttachmentService.findById(id));
    }

    @GetMapping("/findByMusic/{music}")
    public ResponseEntity<MusicAttachment> findByMusic(@PathVariable("music") Long music){
        return ResponseEntity.ok().body(musicAttachmentService.findByMusic(music));
    }

    @GetMapping("/findByTypeAttachment/{typeAttachment}")
    public ResponseEntity<MusicAttachment> findByTypeAttachment(@PathVariable("typeAttachment") String typeAttachment){
        return ResponseEntity.ok().body(musicAttachmentService.findByTypeAttachment(TypeAttachmentEnum.toTypeAttachment(typeAttachment)));
    }

    @GetMapping
    public ResponseEntity<List<MusicAttachment>> findAll(){
        return ResponseEntity.ok().body(musicAttachmentService.findAll());
    }

    @PostMapping
    public ResponseEntity<MusicAttachment> register(@RequestBody MusicAttachmentDTO musicAttachmentDTO, UriComponentsBuilder uriBuilder){
        MusicAttachment musicAttachment = musicAttachmentService.register(musicAttachmentDTO);
        return ResponseEntity.ok().body(musicAttachment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicAttachment> update(@RequestBody MusicAttachmentDTO musicAttachmentDTO, @PathVariable("id") Long id){
        return ResponseEntity.ok().body(musicAttachmentService.update(musicAttachmentDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(musicAttachmentService.delete(id));
    }
}

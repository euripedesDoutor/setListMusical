package com.doutor.setListMusical.controllers;

import com.doutor.setListMusical.domain.Tag;
import com.doutor.setListMusical.domain.enumEntity.TypeTagEnum;
import com.doutor.setListMusical.dtos.TagDTO;
import com.doutor.setListMusical.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping("/{id}")
    public ResponseEntity<Tag> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(tagService.findById(id));
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Tag> findByName(@PathVariable("name") String name){
        return ResponseEntity.ok().body(tagService.findByName(name));
    }

    @GetMapping("/findByAcronym/{acronym}")
    public ResponseEntity<Tag> findByAcronym(@PathVariable("acronym") String acronym){
        return ResponseEntity.ok().body(tagService.findByAcronym(acronym));
    }

    @GetMapping("/findByTypeTag/{typeTag}")
    public ResponseEntity<Tag> findByTypeTag(@PathVariable("typeTag") String typeTag){
        return ResponseEntity.ok().body(tagService.findByTypeTag(TypeTagEnum.toTypeTag(typeTag)));
    }

    @GetMapping
    public ResponseEntity<List<Tag>> findAll(){
        return ResponseEntity.ok().body(tagService.findAll());
    }

    @PostMapping
    public ResponseEntity<Tag> register(@RequestBody TagDTO tagDTO, UriComponentsBuilder uriBuilder){
        Tag tag = tagService.register(tagDTO);
        return ResponseEntity.ok().body(tag);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> update(@RequestBody TagDTO tagDTO, @PathVariable("id") Long id){
        return ResponseEntity.ok().body(tagService.update(tagDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(tagService.delete(id));
    }
}

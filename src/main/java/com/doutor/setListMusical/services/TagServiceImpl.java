package com.doutor.setListMusical.services;

import com.doutor.setListMusical.domain.Tag;
import com.doutor.setListMusical.domain.enumEntity.TypeTagEnum;
import com.doutor.setListMusical.dtos.TagDTO;
import com.doutor.setListMusical.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public Tag findById(Long id) {
        return returnTag(id);
    }

    @Override
    public Tag findByAcronym(String acronym) {
        return returnTag(acronym);
    }

    @Override
    public Tag findByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public Tag findByTypeTag(TypeTagEnum typeTag) {
        return tagRepository.findByTypeTag(typeTag);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag register(TagDTO tagDTO) {
        Tag tag = new Tag(tagDTO);
        tag = tagRepository.save(tag);
        return tag;
    }

    @Override
    public Tag update(TagDTO tagDTO, Long id) {
        Tag tag = returnTag(id);
        tag = loadData(tag, tagDTO);
        return tagRepository.save(tag);
    }

    @Override
    public String delete(Long id) {
        tagRepository.deleteById(id);
        return "Tag ID: " + id + " deleted";
    }

    private Tag returnTag(Long id) {
        return tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Tag wasn't found on database"));
    }

    private Tag returnTag(String acronym) {
        return tagRepository.findByAcronym(acronym);
    }

    private Tag loadData(Tag tag, TagDTO tagDTO){
        tag.setName(tagDTO.name());
        tag.setAcronym(tagDTO.acronym());
        tag.setTypeTag(tagDTO.typeTag());
        return tag;
    }
}

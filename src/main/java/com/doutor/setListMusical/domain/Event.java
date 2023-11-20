package com.doutor.setListMusical.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "event")
@NoArgsConstructor
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEvent;
    @ManyToOne
    private SetList setList;
    @OneToMany
    private List<EventMember> listMember;

    @Builder
    public Event(String name, Date dateEvent, SetList setList, List<EventMember> listMember) {
        this.name = name;
        this.dateEvent = dateEvent;
        this.setList = setList;
        this.listMember = listMember;
    }
}

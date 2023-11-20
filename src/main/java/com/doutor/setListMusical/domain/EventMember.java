package com.doutor.setListMusical.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "event_member")
@NoArgsConstructor
@Getter
@Setter
public class EventMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private Boolean userAdministratorEvent;
    @ManyToOne
    private User user;

    @Builder
    public EventMember(Boolean userAdministratorEvent, User user) {
        this.userAdministratorEvent = userAdministratorEvent;
        this.user = user;
    }
}

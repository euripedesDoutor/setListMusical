package com.doutor.setListMusical.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "musical_group_member")
@NoArgsConstructor
@Getter
@Setter
public class MusicalGroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    private User user;
    private Boolean userAdministradorMusicalGroup;

    @Builder
    public MusicalGroupMember(User user, Boolean userAdministradorMusicalGroup) {
        this.user = user;
        this.userAdministradorMusicalGroup = userAdministradorMusicalGroup;
    }
}

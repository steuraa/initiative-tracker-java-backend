package com.steuraa.inittrackerjava.core.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "encounterSchemas")
public class EncounterSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer round;
    @ManyToMany
    @JoinTable(name = "heroes_encounter", schema = "public",
    joinColumns = @JoinColumn(name = "schema_id"),
    inverseJoinColumns = @JoinColumn(name = "hero_id"))
    private Set<EncounterHero> encounterHeroes;
    @ManyToMany
    @JoinTable(name = "monsters_encounter", schema = "public",
            joinColumns = @JoinColumn(name = "schema_id"),
            inverseJoinColumns = @JoinColumn(name = "monster_id"))
    private Set<EncounterMonster> encounterMonsters;

}

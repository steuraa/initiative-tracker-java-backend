package com.steuraa.inittrackerjava.core.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="encounterMonsters")
public class EncounterMonster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String original_id;
    @NotNull
    private String name;
    @NotNull
    private Integer hp;
    @NotNull
    private Integer max_hp;
    @NotNull
    private Integer ac;
    @NotNull
    private boolean played;
    @NotNull
    private Integer init_mod;
    @NotNull
    private Integer initiative;
    @NotNull
    private boolean disabled;

    @ManyToMany(mappedBy = "encounterHeroes")
    private Set<EncounterSchema> encounters;

    public Long getId() {
        return id;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginal_id() {
        return original_id;
    }

    public void setOriginal_id(String original_id) {
        this.original_id = original_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(Integer max_hp) {
        this.max_hp = max_hp;
    }

    public Integer getAc() {
        return ac;
    }

    public void setAc(Integer ac) {
        this.ac = ac;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public Integer getInit_mod() {
        return init_mod;
    }

    public void setInit_mod(Integer init_mod) {
        this.init_mod = init_mod;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Set<EncounterSchema> getEncounters() {
        return encounters;
    }

    public void setEncounters(Set<EncounterSchema> encounters) {
        this.encounters = encounters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterMonster that = (EncounterMonster) o;
        return id.equals(that.id) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

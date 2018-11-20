package com.steuraa.inittrackerjava.core.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="ProgressencounterHeroes")
public class EncounterHero {
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
	@ManyToOne
	@JoinColumn(name = "progressEncounterId", referencedColumnName = "id", nullable = false)
	private ProgressEncounter progressEncounter;

    public Long getId() {
        return id;
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
	
	public ProgressEncounter getProgressEncounter() {
		return progressEncounter;
	}
	
	public void setProgressEncounter(ProgressEncounter progressEncounter) {
		this.progressEncounter = progressEncounter;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterHero that = (EncounterHero) o;
        return id.equals(that.id) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

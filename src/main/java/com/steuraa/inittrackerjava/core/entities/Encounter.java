package com.steuraa.inittrackerjava.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "encounters")
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer round;
    @OneToMany(mappedBy = "encounter")
    private Set<ProgressEncounter> progressEncounters;
    @ManyToMany
    @JoinTable(name = "heroes_encounter_join", schema = "public",
    joinColumns = @JoinColumn(name = "encounter_id"),
    inverseJoinColumns = @JoinColumn(name = "hero_id"))
    private Set<Hero> Heroes;
    @ManyToMany
    @JoinTable(name = "monsters_encounter_join", schema = "public",
            joinColumns = @JoinColumn(name = "encounter_id"),
            inverseJoinColumns = @JoinColumn(name = "monster_id"))
    private Set<Monster> Monsters;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getRound() {
		return round;
	}
	
	public void setRound(Integer round) {
		this.round = round;
	}
	
	public Set<ProgressEncounter> getProgressEncounters() {
		return progressEncounters;
	}
	
	public void setProgressEncounters(Set<ProgressEncounter> progressEncounters) {
		this.progressEncounters = progressEncounters;
	}
	
	public Set<Hero> getHeroes() {
		return Heroes;
	}
	
	public void setHeroes(Set<Hero> heroes) {
		Heroes = heroes;
	}
	
	public Set<Monster> getMonsters() {
		return Monsters;
	}
	
	public void setMonsters(Set<Monster> monsters) {
		Monsters = monsters;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Encounter encounter = (Encounter) o;
		
		if (!id.equals(encounter.id)) return false;
		return name.equals(encounter.name);
	}
	
	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + name.hashCode();
		return result;
	}
}

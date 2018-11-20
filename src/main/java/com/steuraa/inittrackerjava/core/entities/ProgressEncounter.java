package com.steuraa.inittrackerjava.core.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "progressencounters")
public class ProgressEncounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private Integer round;
	@ManyToOne
	@JoinColumn(name = "encounterId", referencedColumnName = "id", nullable = false)
	private Encounter encounter;
	@OneToMany(mappedBy = "progressEncounter")
	private Set<EncounterHero> encounterHeroes;
	@OneToMany(mappedBy = "progressEncounter")
	private Set<EncounterMonster> encounterMonsters;
	
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
	
	public Encounter getEncounter() {
		return encounter;
	}
	
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	
	public Set<EncounterHero> getEncounterHeroes() {
		return encounterHeroes;
	}
	
	public void setEncounterHeroes(Set<EncounterHero> encounterHeroes) {
		this.encounterHeroes = encounterHeroes;
	}
	
	public Set<EncounterMonster> getEncounterMonsters() {
		return encounterMonsters;
	}
	
	public void setEncounterMonsters(Set<EncounterMonster> encounterMonsters) {
		this.encounterMonsters = encounterMonsters;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		ProgressEncounter that = (ProgressEncounter) o;
		
		if (!id.equals(that.id)) return false;
		return name.equals(that.name);
	}
	
	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + name.hashCode();
		return result;
	}
}

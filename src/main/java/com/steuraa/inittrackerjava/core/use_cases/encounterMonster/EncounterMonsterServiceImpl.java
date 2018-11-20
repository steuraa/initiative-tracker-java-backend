package com.steuraa.inittrackerjava.core.use_cases.encounterMonster;

import com.steuraa.inittrackerjava.core.entities.EncounterMonster;
import com.steuraa.inittrackerjava.core.exception.NotFoundException;
import com.steuraa.inittrackerjava.core.gateways.Gateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EncounterMonsterServiceImpl implements EncounterMonsterService {
	private static Gateway<EncounterMonster> encounterMonsterGateway;
	
	@Autowired
	public EncounterMonsterServiceImpl(Gateway<EncounterMonster> encounterMonsterGateway) {this.encounterMonsterGateway = encounterMonsterGateway;}
	
	@Override
	public List<EncounterMonster> getAll() {
		return this.encounterMonsterGateway.findAll();
	}
	
	@Override
	public EncounterMonster getById(Long id) {
		return this.encounterMonsterGateway.findById(id).orElseThrow(() -> new NotFoundException("No monster with id: " + id));
	}
	
	@Override
	public EncounterMonster create(EncounterMonster monster) {
		return this.encounterMonsterGateway.save(monster);
	}
	
	@Override
	public EncounterMonster update(Long id, EncounterMonster monster) {
		this.getById(id);
		monster.setId(id);
		return this.encounterMonsterGateway.save(monster);
	}
	
	@Override
	public void delete(Long id) {
		this.encounterMonsterGateway.deleteById(id);
	}
}

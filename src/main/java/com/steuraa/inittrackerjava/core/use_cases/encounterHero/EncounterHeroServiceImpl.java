package com.steuraa.inittrackerjava.core.use_cases.encounterHero;

import com.steuraa.inittrackerjava.core.entities.EncounterHero;
import com.steuraa.inittrackerjava.core.exception.NotFoundException;
import com.steuraa.inittrackerjava.core.gateways.Gateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncounterHeroServiceImpl implements EncounterHeroService {
	
	private static Gateway<EncounterHero> encounterHeroGateway;
	
	@Autowired
	public EncounterHeroServiceImpl(Gateway<EncounterHero> encounterHeroGateway) {
		this.encounterHeroGateway = encounterHeroGateway;
	}
	@Override
	public List<EncounterHero> getAll() {return this.encounterHeroGateway.findAll();}
	
	@Override
	public EncounterHero getById(Long id) {
		return this.encounterHeroGateway.findById(id).orElseThrow(() -> new NotFoundException("No hero with id: " + id));
	}
	
	@Override
	public EncounterHero create(EncounterHero encounterHero) {
		return this.encounterHeroGateway.save(encounterHero);
	}
	
	@Override
	public EncounterHero update(Long id, EncounterHero encounterHero) {
		this.getById(id);
		encounterHero.setId(id);
		return this.encounterHeroGateway.save(encounterHero);
	}
	
	@Override
	public void delete(Long id) {
		this.getById(id);
		this.encounterHeroGateway.deleteById(id);
	}
}

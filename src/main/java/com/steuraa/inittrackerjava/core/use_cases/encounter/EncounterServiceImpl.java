package com.steuraa.inittrackerjava.core.use_cases.encounter;

import com.steuraa.inittrackerjava.core.entities.Encounter;
import com.steuraa.inittrackerjava.core.exception.NotFoundException;
import com.steuraa.inittrackerjava.core.gateways.Gateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncounterServiceImpl implements EncounterService {
	
	public final Gateway<Encounter> encounterGateway;
	
	@Autowired
	public EncounterServiceImpl(Gateway<Encounter> encounterGateway) {
		this.encounterGateway = encounterGateway;
	}
	
	@Override
	public List<Encounter> getAll() {return this.encounterGateway.findAll();}
	
	@Override
	public Encounter getById(Long id) {
		return this.encounterGateway.findById(id).orElseThrow(() -> new NotFoundException("No encounter with id: " + id));
	}
	
	@Override
	public Encounter create(Encounter encounter) {
		return new Encounter();
	}
	
	@Override
	public Encounter update(Long id, Encounter encounter) {
		return new Encounter();
	}
	
	@Override
	public void delete(Long id) {
		this.getById(id);
		this.encounterGateway.deleteById(id);
	}
}

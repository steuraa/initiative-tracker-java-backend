package com.steuraa.inittrackerjava.core.use_cases.progresEncounter;

import com.steuraa.inittrackerjava.core.entities.Encounter;
import com.steuraa.inittrackerjava.core.entities.ProgressEncounter;
import com.steuraa.inittrackerjava.core.exception.NotFoundException;
import com.steuraa.inittrackerjava.core.gateways.Gateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressEncounterServiceImpl implements ProgressEncounterService {
	
	private final Gateway<ProgressEncounter> progressEncounterGateway;
	
	@Autowired
	public ProgressEncounterServiceImpl(Gateway<ProgressEncounter> progressEncounterGateway) {
		this.progressEncounterGateway = progressEncounterGateway;
	}
	
	@Override
	public List<ProgressEncounter> getAll() {return this.progressEncounterGateway.findAll();}
	
	@Override
	public ProgressEncounter getById(Long id) {
		return this.progressEncounterGateway.findById(id).orElseThrow(() -> new NotFoundException("No progress-encounter with id: " + id));
	}
	
	@Override
	public ProgressEncounter create(ProgressEncounter encounter) {
		ProgressEncounter temp = new ProgressEncounter();
		return new ProgressEncounter();
	}
	
	@Override
	public ProgressEncounter update(Long id, ProgressEncounter encounter) {
		return new ProgressEncounter();
	}
	
	@Override
	public void delete(Long id) {
		this.getById(id);
		this.progressEncounterGateway.deleteById(id);
	}
}

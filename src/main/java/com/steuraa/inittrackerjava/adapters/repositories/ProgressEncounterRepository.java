package com.steuraa.inittrackerjava.adapters.repositories;

import com.steuraa.inittrackerjava.core.entities.ProgressEncounter;
import com.steuraa.inittrackerjava.core.gateways.Gateway;
import org.springframework.data.repository.CrudRepository;

public interface ProgressEncounterRepository extends CrudRepository<ProgressEncounter, Long>, Gateway<ProgressEncounter> {
}

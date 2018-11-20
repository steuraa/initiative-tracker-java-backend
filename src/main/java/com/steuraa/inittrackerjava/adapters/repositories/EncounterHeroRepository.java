package com.steuraa.inittrackerjava.adapters.repositories;

import com.steuraa.inittrackerjava.core.gateways.Gateway;
import com.steuraa.inittrackerjava.core.entities.EncounterHero;
import org.springframework.data.repository.CrudRepository;

public interface EncounterHeroRepository extends CrudRepository<EncounterHero, Gateway> {
}

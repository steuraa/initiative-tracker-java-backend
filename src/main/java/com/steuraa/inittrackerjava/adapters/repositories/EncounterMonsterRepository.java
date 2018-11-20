package com.steuraa.inittrackerjava.adapters.repositories;

import com.steuraa.inittrackerjava.core.gateways.Gateway;
import com.steuraa.inittrackerjava.core.entities.EncounterMonster;
import org.springframework.data.repository.CrudRepository;

public interface EncounterMonsterRepository extends CrudRepository<EncounterMonster, Gateway> {
}

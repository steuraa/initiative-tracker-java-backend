package com.steuraa.inittrackerjava.adapters.repositories;

import com.steuraa.inittrackerjava.core.gateways.Gateway;
import com.steuraa.inittrackerjava.core.entities.Monster;
import org.springframework.data.repository.CrudRepository;

public interface MonsterRepository extends CrudRepository<Monster, Long>, Gateway<Monster> {
}

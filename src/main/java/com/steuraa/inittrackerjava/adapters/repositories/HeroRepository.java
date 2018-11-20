package com.steuraa.inittrackerjava.adapters.repositories;

import com.steuraa.inittrackerjava.core.gateways.Gateway;
import com.steuraa.inittrackerjava.core.entities.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Long>, Gateway<Hero> {
}

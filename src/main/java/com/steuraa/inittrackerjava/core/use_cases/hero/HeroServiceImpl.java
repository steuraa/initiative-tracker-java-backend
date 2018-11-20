package com.steuraa.inittrackerjava.core.use_cases.hero;

import com.steuraa.inittrackerjava.core.gateways.Gateway;
import com.steuraa.inittrackerjava.core.entities.Hero;
import com.steuraa.inittrackerjava.core.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {
    private final Gateway<Hero> heroGateway;

    @Autowired
    public HeroServiceImpl(Gateway<Hero> heroGateway) {
        this.heroGateway = heroGateway;
    }

    @Override
    public List<Hero> getAll() {return this.heroGateway.findAll();}

    @Override
    public Hero getById(Long id) {
        return this.heroGateway.findById(id).orElseThrow(() -> new NotFoundException("No hero with id: " + id));
    }

    @Override
    public Hero create(Hero hero) {
        return this.heroGateway.save(hero);
    }

    @Override
    public Hero update(Long id, Hero hero) {
        this.getById(id);
        hero.setId(id);
        return this.heroGateway.save(hero);
    }

    @Override
    public void delete(Long id) {
        this.getById(id);
        this.heroGateway.deleteById(id);
    }

}

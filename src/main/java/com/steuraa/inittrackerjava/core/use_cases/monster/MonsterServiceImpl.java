package com.steuraa.inittrackerjava.core.use_cases.monster;

import com.steuraa.inittrackerjava.core.entities.Monster;
import com.steuraa.inittrackerjava.core.exception.NotFoundException;
import com.steuraa.inittrackerjava.core.gateways.Gateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterServiceImpl implements MonsterService {
    private final Gateway<Monster> monsterGateway;

    @Autowired
    public MonsterServiceImpl(Gateway<Monster> monsterGateway) {
        this.monsterGateway = monsterGateway;
    }

    @Override
    public List<Monster> getAll() {
        return this.monsterGateway.findAll();
    }

    @Override
    public Monster getById(Long id) {
        return this.monsterGateway.findById(id).orElseThrow(() -> new NotFoundException("No monster with id: " + id));
    }

    @Override
    public Monster create(Monster monster) {
        return this.monsterGateway.save(monster);
    }

    @Override
    public Monster update(Long id, Monster monster) {
        this.getById(id);
        monster.setId(id);
        return this.monsterGateway.save(monster);
    }

    @Override
    public void delete(Long id) {
        this.monsterGateway.deleteById(id);
    }
}

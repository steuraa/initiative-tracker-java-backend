package com.steuraa.inittrackerjava.entrypoints.rest;

import com.steuraa.inittrackerjava.core.entities.Monster;
import com.steuraa.inittrackerjava.core.exception.NotFoundException;
import com.steuraa.inittrackerjava.core.use_cases.monster.MonsterService;
import com.steuraa.inittrackerjava.entrypoints.error_entities.ErrorResponse;
import com.steuraa.inittrackerjava.entrypoints.error_entities.RequestBodyError;
import com.steuraa.inittrackerjava.entrypoints.error_entities.RequestBodyErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/monsters")
public class MonsterController {
    private final MonsterService monsterService;

    @Autowired

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity getAllMonsters() {
        return ResponseEntity.status(HttpStatus.OK).body(monsterService.getAll());
    }

    @GetMapping(produces = "application/json", value = "/{id}")
    public ResponseEntity getMonsterById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(monsterService.getById(id));
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity createMonster(@Valid @RequestBody Monster monster, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestBodyErrors(errors));
        }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    this.monsterService.create(monster));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity updateHero(@PathVariable Long id, @Valid @RequestBody Monster monster, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestBodyErrors(errors));
        if (!id.equals(monster.getId()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestBodyErrors(new RequestBodyError("id",
                    "id in url path and id of object do not match")));
        return ResponseEntity.status(HttpStatus.OK).body(monsterService.update(monster.getId(), monster));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteHero(@PathVariable("id") Long id) {
        monsterService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}

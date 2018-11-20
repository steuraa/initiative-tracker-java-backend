package com.steuraa.inittrackerjava.entrypoints.rest;

import com.steuraa.inittrackerjava.core.entities.Hero;
import com.steuraa.inittrackerjava.core.exception.NotFoundException;
import com.steuraa.inittrackerjava.core.use_cases.hero.HeroService;
import com.steuraa.inittrackerjava.entrypoints.dto.HeroDTO;
import com.steuraa.inittrackerjava.entrypoints.error_entities.ErrorResponse;
import com.steuraa.inittrackerjava.entrypoints.error_entities.RequestBodyError;
import com.steuraa.inittrackerjava.entrypoints.error_entities.RequestBodyErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity getAllHeroes() {
        return ResponseEntity.status(HttpStatus.OK).body(heroService.getAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity getHeroById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(heroService.getById(id));
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity createHero(@Valid @RequestBody Hero hero, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestBodyErrors(errors));
        }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    this.heroService.create(hero));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity updateHero(@PathVariable Long id, @Valid @RequestBody Hero hero, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestBodyErrors(errors));
        if (!id.equals(hero.getId()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestBodyErrors(new RequestBodyError("id",
                    "id in url path and id of object do not match")));
        return ResponseEntity.status(HttpStatus.OK).body(heroService.update(hero.getId(), hero));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteHero(@PathVariable("id") Long id) {
        heroService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

}

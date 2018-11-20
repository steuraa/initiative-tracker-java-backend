package com.steuraa.inittrackerjava.entrypoints.rest;

import com.steuraa.inittrackerjava.core.entities.ProgressEncounter;
import com.steuraa.inittrackerjava.core.exception.NotFoundException;
import com.steuraa.inittrackerjava.core.use_cases.progresEncounter.ProgressEncounterService;
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
@RequestMapping("/api/encounters")
public class ProgressEncounterController {
    private final ProgressEncounterService progressEncounterService;

    @Autowired

    public ProgressEncounterController(ProgressEncounterService progressEncounterService) {
        this.progressEncounterService = progressEncounterService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity getAllEncounters() {
        return ResponseEntity.status(HttpStatus.OK).body(progressEncounterService.getAll());
    }

    @GetMapping(produces = "application/json", value = "/{id}")
    public ResponseEntity getEncounterById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(progressEncounterService.getById(id));
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity createEncounter(@Valid @RequestBody ProgressEncounter progressEncounter, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestBodyErrors(errors));
        }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    this.progressEncounterService.create(progressEncounter));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity updateEncounter(@PathVariable Long id, @Valid @RequestBody ProgressEncounter progressEncounter, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestBodyErrors(errors));
        if (!id.equals(progressEncounter.getId()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestBodyErrors(new RequestBodyError("id",
                    "id in url path and id of object do not match")));
        return ResponseEntity.status(HttpStatus.OK).body(progressEncounterService.update(progressEncounter.getId(), progressEncounter));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteEncounter(@PathVariable("id") Long id) {
        progressEncounterService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}

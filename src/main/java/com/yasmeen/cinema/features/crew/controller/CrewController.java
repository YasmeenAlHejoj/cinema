package com.yasmeen.cinema.features.crew.controller;

import com.yasmeen.cinema.features.crew.entity.Crew;
import com.yasmeen.cinema.features.crew.service.CrewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/28/2022 at 3:36 PM
 * @project CinemaApp
 */
@RestController
@RequestMapping("crew")
public class CrewController {
    private final CrewService crewService;

    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }


    @PostMapping
    public Crew add(@RequestBody Crew crew) {
        return crewService.saveCrew(crew);
    }

    @PutMapping
    public Crew update(@RequestBody Crew crew) {
        return crewService.updateCrew(crew);
    }

    @GetMapping
    public List<Crew> get() {
        return crewService.getCrews();
    }

    @GetMapping("byId/{crewId}")
    public Crew getById(@PathVariable int crewId) {
        return crewService.getCrewById(crewId);
    }

    @DeleteMapping("{crewId}")
    public boolean delete(@PathVariable int crewId) {
        return crewService.deleteCrew(crewId);
    }
}

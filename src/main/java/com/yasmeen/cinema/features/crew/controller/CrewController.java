package com.yasmeen.cinema.features.crew.controller;

import com.yasmeen.cinema.features.crew.dao.CrewDao;
import com.yasmeen.cinema.features.crew.entity.Crew;
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
    private final CrewDao crewDao;

    public CrewController(CrewDao crewDao) {
        this.crewDao = crewDao;
    }


    @PostMapping
    public Crew add(@RequestBody Crew crew) {
        return crewDao.saveCrew(crew);
    }

    @PutMapping
    public Crew update(@RequestBody Crew crew) {
        return crewDao.updateCrew(crew);
    }

    @GetMapping
    public List<Crew> get() {
        return crewDao.getCrews();
    }

    @GetMapping("byId/{crewId}")
    public Crew getById(@PathVariable int crewId) {
        return crewDao.getCrewById(crewId);
    }

    @DeleteMapping("{crewId}")
    public boolean delete(@PathVariable int crewId) {
        return crewDao.deleteCrew(crewId);
    }
}

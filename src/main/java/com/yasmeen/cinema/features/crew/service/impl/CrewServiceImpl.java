package com.yasmeen.cinema.features.crew.service.impl;

import com.yasmeen.cinema.features.crew.dao.CrewDAO;
import com.yasmeen.cinema.features.crew.entity.Crew;
import com.yasmeen.cinema.features.crew.service.CrewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/29/2022 at 12:54 PM
 * @project CinemaApp
 */
@Service
@Transactional
public class CrewServiceImpl implements CrewService {
    private final CrewDAO crewDao;

    public CrewServiceImpl(CrewDAO crewDao) {
        this.crewDao = crewDao;
    }

    @Override
    @Transactional
    public Crew saveCrew(Crew crew) {
        return crewDao.saveCrew(crew);
    }

    @Override
    @Transactional
    public Crew updateCrew(Crew crew) {
        return crewDao.updateCrew(crew);
    }

    @Override
    @Transactional
    public Crew getCrewById(int crewId) {
        return crewDao.getCrewById(crewId);
    }

    @Override
    @Transactional
    public List<Crew> getCrews() {
        return crewDao.getCrews();
    }

    @Override
    public List<Crew> getCrewsByMovieId(int movieId) {
        return crewDao.getCrewsByMovieId(movieId);
    }

    @Override
    @Transactional
    public boolean deleteCrew(int crewId) {
        return crewDao.deleteCrew(crewId);
    }
}

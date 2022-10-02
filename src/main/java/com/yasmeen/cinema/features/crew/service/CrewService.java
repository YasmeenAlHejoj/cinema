package com.yasmeen.cinema.features.crew.service;

import com.yasmeen.cinema.features.crew.entity.Crew;

import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/29/2022 at 12:50 PM
 * @project CinemaApp
 */
public interface CrewService {

    Crew saveCrew(Crew crew);

    Crew updateCrew(Crew crew);

    Crew getCrewById(int crewId);

    List<Crew> getCrews();

    List<Crew> getCrewsByMovieId(int movieId);

    boolean deleteCrew(int crewId);
}

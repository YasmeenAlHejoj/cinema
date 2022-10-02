package com.yasmeen.cinema.features.crew.dao;

import com.yasmeen.cinema.features.crew.entity.Crew;

import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/28/2022 at 3:41 PM
 * @project CinemaApp
 */
public interface CrewDAO {

    Crew saveCrew(Crew crew);

    Crew updateCrew(Crew crew);

    Crew getCrewById(int crewId);

    List<Crew> getCrews();

    boolean deleteCrew(int crewId);

    List<Crew> getCrewsByMovieId(int movieId);
}

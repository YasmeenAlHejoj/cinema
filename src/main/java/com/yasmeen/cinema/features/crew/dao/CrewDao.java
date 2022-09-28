package com.yasmeen.cinema.features.crew.dao;

import com.yasmeen.cinema.features.crew.entity.Crew;
import com.yasmeen.cinema.features.movie.entity.Movie;

import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/28/2022 at 3:41 PM
 * @project CinemaApp
 */
public interface CrewDao {

    Crew saveCrew(Crew Crew);

    Crew updateCrew(Crew Crew);

    Crew getCrewById(int CrewId);

    List<Crew> getCrews();

    boolean deleteCrew(int CrewId);
}

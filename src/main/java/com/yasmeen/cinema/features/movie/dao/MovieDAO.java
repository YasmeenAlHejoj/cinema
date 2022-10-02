package com.yasmeen.cinema.features.movie.dao;

import com.yasmeen.cinema.features.crew.entity.Crew;
import com.yasmeen.cinema.features.movie.entity.Movie;

import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/22/2022 at 4:21 PM
 * @project CinemaApp
 */
public interface MovieDAO {
    Movie saveMovie(Movie movie);
    Movie updateMovie(Movie movie);

    Movie getMovieById(int movieId);
    List<Movie> getMovies();
    boolean deleteMovie(int movieId);

    List<Crew> getCrewOfMovie(int movieId);
}

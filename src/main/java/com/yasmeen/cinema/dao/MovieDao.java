package com.yasmeen.cinema.dao;

import com.yasmeen.cinema.entity.Movie;

import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/22/2022 at 4:21 PM
 * @project CinemaApp
 */
public interface MovieDao {
    Movie saveMovie(Movie movie);
    Movie updateMovie(Movie movie);

    Movie getMovieById(int movieId);
    List<Movie> getMovies();
    boolean deleteMovie(int movieId);
}

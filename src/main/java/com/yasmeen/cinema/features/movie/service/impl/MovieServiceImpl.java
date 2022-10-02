package com.yasmeen.cinema.features.movie.service.impl;

import com.yasmeen.cinema.features.crew.entity.Crew;
import com.yasmeen.cinema.features.movie.dao.MovieDAO;
import com.yasmeen.cinema.features.movie.entity.Movie;
import com.yasmeen.cinema.features.movie.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/29/2022 at 1:02 PM
 * @project CinemaApp
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    private final MovieDAO movieDAO;

    public MovieServiceImpl(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @Override
    @Transactional
    public Movie saveMovie(Movie movie) {
        return movieDAO.saveMovie(movie);
    }

    @Override
    @Transactional
    public Movie updateMovie(Movie movie) {
        return movieDAO.updateMovie(movie);
    }

    @Override
    @Transactional
    public Movie getMovieById(int movieId) {
        return movieDAO.getMovieById(movieId);
    }
    @Override
    @Transactional
    public List<Movie> getMovies() {
        return movieDAO.getMovies();
    }
    @Override
    @Transactional
    public boolean deleteMovie(int movieId) {
        return movieDAO.deleteMovie(movieId);
    }
    @Override
    @Transactional
    public List<Crew> getCrewOfMovie(int movieId) {
        return movieDAO.getCrewOfMovie(movieId);
    }
}

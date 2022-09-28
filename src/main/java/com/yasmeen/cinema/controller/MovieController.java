package com.yasmeen.cinema.controller;

import com.yasmeen.cinema.dao.MovieDao;
import com.yasmeen.cinema.entity.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/22/2022 at 4:14 PM
 * @project CinemaApp
 */
@RestController
@RequestMapping("movie")
public class MovieController {
    private final MovieDao movieDao;

    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie) {
        return movieDao.saveMovie(movie);
    }

    @GetMapping
    public List<Movie> get() {
        return movieDao.getMovies();
    }

    @GetMapping("byId/{movieId}")
    public Movie getById(@PathVariable int movieId) {
        return movieDao.getMovieById(movieId);
    }

    @DeleteMapping("{movieId}")
    public boolean delete(@PathVariable int movieId) {
        return movieDao.deleteMovie(movieId);
    }
}

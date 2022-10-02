package com.yasmeen.cinema.features.movie.controller;

import com.yasmeen.cinema.features.crew.entity.Crew;
import com.yasmeen.cinema.features.movie.entity.Movie;
import com.yasmeen.cinema.features.movie.service.MovieService;
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
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @PostMapping
    public Movie add(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @PutMapping
    public Movie update(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @GetMapping
    public List<Movie> get() {
        return movieService.getMovies();
    }

    @GetMapping("byId/{movieId}")
    public Movie getById(@PathVariable int movieId) {
        return movieService.getMovieById(movieId);
    }

    @DeleteMapping("{movieId}")
    public boolean delete(@PathVariable int movieId) {
        return movieService.deleteMovie(movieId);
    }

    @GetMapping("crewOfMovie/{movieId}")
    public List<Crew> getCrewOfMovie(@PathVariable int movieId) {
        return movieService.getCrewOfMovie(movieId);
    }
}

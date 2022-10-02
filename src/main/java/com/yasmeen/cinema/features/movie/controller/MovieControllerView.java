package com.yasmeen.cinema.features.movie.controller;

import com.yasmeen.cinema.features.movie.entity.Movie;
import com.yasmeen.cinema.features.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/27/2022 at 1:41 PM
 * @project CinemaApp
 */
@Controller
@RequestMapping("/view")
public class MovieControllerView {
    private final MovieService movieService;

    public MovieControllerView(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("viewList")
    public String viewList(Model model) {
        List<Movie> movies = movieService.getMovies();
        model.addAttribute("movieList", movies);
        System.out.println(movies);
        return "movie/movie-list";
    }

    @GetMapping("showFormUpdate")
    public String showFormUpdate(@RequestParam("movieId") int movieId
        , Model model) {

        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "movie/movie-update-form";
    }


    @PostMapping("updateMovie")
    public String updateMovie(@ModelAttribute("movie") Movie movie) {
        movieService.updateMovie(movie);
        return "redirect:/view/viewList";
    }


    @GetMapping("showAddForm")
    public String showAddForm(Model model) {
        Movie movie =new Movie();
        model.addAttribute("movie", movie);
        return "movie/movie-add-form";
    }
    @PostMapping("addMovie")
    public String addMovie(@ModelAttribute("movie") Movie movie) {

        System.out.println(movie.getReleaseDate());
        System.out.println(movie.getCreateAt());

        movieService.saveMovie(movie);
        return "redirect:/view/viewList";
    }




    @GetMapping("deleteMovie")
    public String deleteMovie(@RequestParam("movieId") int movieId) {
        movieService.deleteMovie(movieId);
        return "redirect:/view/viewList";
    }
}

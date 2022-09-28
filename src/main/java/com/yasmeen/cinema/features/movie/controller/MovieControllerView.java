package com.yasmeen.cinema.features.movie.controller;

import com.yasmeen.cinema.features.movie.dao.MovieDao;
import com.yasmeen.cinema.features.movie.entity.Movie;
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
    private final MovieDao movieDao;

    public MovieControllerView(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @GetMapping("viewList")
    public String viewList(Model model) {
        List<Movie> movies = movieDao.getMovies();
        model.addAttribute("movieList", movies);
        System.out.println(movies);
        return "movie/movie-list";
    }

    @GetMapping("showFormUpdate")
    public String showFormUpdate(@RequestParam("movieId") int movieId
        , Model model) {

        Movie movie = movieDao.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "movie/movie-update-form";
    }


    @PostMapping("updateMovie")
    public String updateMovie(@ModelAttribute("movie") Movie movie) {
        movieDao.updateMovie(movie);
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
        movieDao.saveMovie(movie);
        return "redirect:/view/viewList";
    }




    @GetMapping("deleteMovie")
    public String deleteMovie(@RequestParam("movieId") int movieId) {
        movieDao.deleteMovie(movieId);
        return "redirect:/view/viewList";
    }
}

package com.yasmeen.cinema.features.crew.controller;

import com.yasmeen.cinema.features.crew.entity.Crew;
import com.yasmeen.cinema.features.crew.entity.constants.CrewType;
import com.yasmeen.cinema.features.crew.service.CrewService;
import com.yasmeen.cinema.features.movie.entity.Movie;
import org.hibernate.loader.entity.CascadeEntityJoinWalker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/29/2022 at 2:11 PM
 * @project CinemaApp
 */
@Controller
@RequestMapping("crewView")
public class CrewControllerView {

    private final CrewService crewService;

    public CrewControllerView(CrewService crewService) {
        this.crewService = crewService;
    }

    @GetMapping("crewByMovieId")
    public String getCrewByMovieId(@RequestParam int movieId, Model model) {
        List<Crew> crewsByMovieId = crewService.getCrewsByMovieId(movieId);
        model.addAttribute("crews", crewsByMovieId);
        model.addAttribute("movieId", movieId);

        return "crew/crew-list";

    }

    @GetMapping("showAddForm/movieId/{movieId}")
    public String showAddForm(@PathVariable int movieId,
                              Model model) {
        Crew crew = new Crew();
        CrewType[] types = CrewType.values();
        model.addAttribute("crew", crew);
        model.addAttribute("movieId", movieId);
        model.addAttribute("types", types);

        return "crew/crew-add-form";

    }

    @PostMapping("addCrew/{movieId}")
    public String addCrew(@PathVariable int movieId, @ModelAttribute Crew crew) {

        crew.setMovieId(movieId);
        crew.setCreateAt(LocalDateTime.now());
        crewService.saveCrew(crew);
        System.out.println(crew);
        return "redirect:/crewView/crewByMovieId?movieId=" + movieId;

    }

    @GetMapping("showFormUpdate")
    public String showFormUpdate(@RequestParam int crewId,
                                 Model model) {
        Crew crewById = crewService.getCrewById(crewId);
        CrewType[] types = CrewType.values();
        model.addAttribute("types", types);
        model.addAttribute("crew", crewById);
        return "crew/crew-update-form";
    }

    @PostMapping("updateCrew")
    public String updateCrew(@ModelAttribute Crew crew) {
        int movieId = crew.getMovieId();
        System.out.println(crew);
        crewService.updateCrew(crew);
        return "redirect:/crewView/crewByMovieId?movieId=" + movieId;
    }


    @GetMapping("deleteCrew")
    public String deleteMovie(@RequestParam("crewId") int crewId,@RequestParam int movieId) {
        crewService.deleteCrew(crewId);
        return "redirect:/crewView/crewByMovieId?movieId=" + movieId;
    }
}

package com.yasmeen.cinema.features.movie.dao;

import com.yasmeen.cinema.features.crew.entity.Crew;
import com.yasmeen.cinema.features.movie.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/22/2022 at 4:23 PM
 * @project CinemaApp
 */
@Repository
public class MovieDaoImpl implements MovieDAO {
    private final SessionFactory sessionFactory;

    public MovieDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        movie.setCreateAt(LocalDateTime.now());
        currentSession.saveOrUpdate(movie);
        // return the results
        return movie;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(movie);
        return movie;
    }

    @Override
    public Movie getMovieById(int movieId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Movie movie = currentSession.get(Movie.class, movieId);
        return movie;
    }

    @Override
    public List<Movie> getMovies() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("From Movie");
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public boolean deleteMovie(int movieId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Movie movieById = getMovieById(movieId);
        if (movieById == null) {
            throw new RuntimeException("Movie Not Found");
        }
        Query query = currentSession.createQuery("delete from Movie where id=:movieId");
        query.setParameter("movieId", movieId);
        query.executeUpdate();
        return true;
    }

    @Override
    public List<Crew> getCrewOfMovie(int movieId) {
        //Session currentSession = sessionFactory.getCurrentSession();
        Movie movieById = getMovieById(movieId);
        List<Crew> crews = movieById.getCrews();
      /*  Query query = currentSession.createQuery("From Crew where movieId=:movieId");
        query.setParameter(movieId,"movieId");
        List resultList = query.getResultList();*/
        return crews;
    }
}

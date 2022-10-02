package com.yasmeen.cinema.features.crew.dao;

import com.yasmeen.cinema.features.crew.entity.Crew;
import com.yasmeen.cinema.features.movie.dao.MovieDAO;
import com.yasmeen.cinema.features.movie.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/28/2022 at 3:48 PM
 * @project CinemaApp
 */
@Repository
public class CrewDaoImpl implements CrewDAO {
    private final SessionFactory sessionFactory;
    private final MovieDAO movieDao;

    public CrewDaoImpl(SessionFactory sessionFactory, MovieDAO movieDao) {
        this.sessionFactory = sessionFactory;
        this.movieDao = movieDao;
    }

    @Override
    public Crew saveCrew(Crew crew) {
        Session currentSession = sessionFactory.getCurrentSession();
        Movie movieById = movieDao.getMovieById(crew.getMovieId());
        if (movieById == null) {
            throw new RuntimeException("No Movie Id Found ");
        }
        crew.setCreateAt(LocalDateTime.now());
        currentSession.save(crew);
        // return the results
        return crew;
    }

    @Override
    public Crew updateCrew(Crew crew) {
        Session currentSession = sessionFactory.getCurrentSession();
        crew.setCreateAt(LocalDateTime.now());
        currentSession.update(crew);
        // return the results
        return crew;
    }

    @Override
    public Crew getCrewById(int crewId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Crew crew = currentSession.get(Crew.class, crewId);
        return crew;
    }

    @Override
    public List<Crew> getCrews() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("From Crew");
        List resultList = query.getResultList();
        return resultList;
    }


    @Override
    public List<Crew> getCrewsByMovieId(int movieId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("From Crew where movieId=:movieId");
        query.setParameter("movieId", movieId);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public boolean deleteCrew(int crewId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Crew crewById = getCrewById(crewId);
        if (crewById == null) {
            throw new RuntimeException("Crew Not Found");
        }
        Query query = currentSession.createQuery("delete from Crew where id=:crewId");
        query.setParameter("crewId", crewId);
        query.executeUpdate();
        return true;
    }


}

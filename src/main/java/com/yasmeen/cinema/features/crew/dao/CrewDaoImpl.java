package com.yasmeen.cinema.features.crew.dao;

import com.yasmeen.cinema.features.crew.entity.Crew;
import com.yasmeen.cinema.features.movie.dao.MovieDao;
import com.yasmeen.cinema.features.movie.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/28/2022 at 3:48 PM
 * @project CinemaApp
 */
@Repository
public class CrewDaoImpl implements CrewDao {
    private final SessionFactory sessionFactory;
    private final MovieDao movieDao;

    public CrewDaoImpl(SessionFactory sessionFactory, MovieDao movieDao) {
        this.sessionFactory = sessionFactory;
        this.movieDao = movieDao;
    }

    @Override
    @Transactional
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
    @Transactional
    public Crew updateCrew(Crew crew) {
        Session currentSession = sessionFactory.getCurrentSession();
        crew.setCreateAt(LocalDateTime.now());
        currentSession.update(crew);
        // return the results
        return crew;
    }

    @Override
    @Transactional
    public Crew getCrewById(int crewId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Crew crew = currentSession.get(Crew.class, crewId);
        return crew;
    }

    @Override
    @Transactional
    public List<Crew> getCrews() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("From Crew");
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    @Transactional
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

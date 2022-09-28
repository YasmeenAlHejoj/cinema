package com.yasmeen.cinema.features.crew.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yasmeen.cinema.config.date.LocalDateTimeDeserializer;
import com.yasmeen.cinema.config.date.LocalDateTimeSerializer;
import com.yasmeen.cinema.features.crew.entity.constants.CrewType;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author YasmeenHj
 * created on 9/28/2022 at 2:11 PM
 * @project CinemaApp
 */
@Entity
@Table(name = "crew")
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "movie_id")
    private int movieId;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private CrewType type;
    @Column(name = "job")
    private String job;
    @Column(name = "characters")
    private String characters;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "create_at")
    private LocalDateTime createAt;


    public Crew() {
    }

    public Crew(int movieId, String name, CrewType type, String job, String characters, LocalDateTime createAt) {
        this.movieId = movieId;
        this.name = name;
        this.type = type;
        this.job = job;
        this.characters = characters;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CrewType getType() {
        return type;
    }

    public void setType(CrewType type) {
        this.type = type;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }


    @Override
    public String toString() {
        return "Crew{" +
            "id=" + id +
            ", movieId=" + movieId +
            ", name='" + name + '\'' +
            ", type=" + type +
            ", job='" + job + '\'' +
            ", characters='" + characters + '\'' +
            ", createAt=" + createAt +
            '}';
    }
}

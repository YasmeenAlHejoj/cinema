package com.yasmeen.cinema.features.movie.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yasmeen.cinema.config.date.LocalDateTimeDeserializer;
import com.yasmeen.cinema.config.date.LocalDateTimeSerializer;
import com.yasmeen.cinema.features.crew.entity.Crew;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author YasmeenHj
 * created on 9/22/2022 at 4:15 PM
 * @project CinemaApp
 */
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "language")
    private String language;
    @Column(name = "type")
    private String type;
    @Column(name = "release_date")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime releaseDate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "is_adult")
    private boolean isAdult;


    @OneToMany(mappedBy = "movieId",
        cascade = {CascadeType.DETACH,
        CascadeType.PERSIST,
        CascadeType.MERGE,
        CascadeType.REFRESH},
        fetch = FetchType.LAZY)
    List<Crew> crews;
    public Movie(String title, String language, String type, LocalDateTime releaseDate, LocalDateTime createAt, boolean isAdult) {
        this.title = title;
        this.language = language;
        this.type = type;
        this.releaseDate = releaseDate;
        this.createAt = createAt;
        this.isAdult = isAdult;
    }

    public Movie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }


    public List<Crew> getCrews() {
        return crews;
    }

    public void setCrews(List<Crew> crews) {
        this.crews = crews;
    }

    @Override
    public String toString() {
        return "Movie{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", language='" + language + '\'' +
            ", type='" + type + '\'' +
            ", releaseDate=" + releaseDate +
            ", createAt=" + createAt +
            ", isAdult=" + isAdult +
            '}';
    }
}

package com.herokuapp.zeversion.quakelogparser.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Game> games;

    public Log() {
        this.games = new ArrayList<>();
    }

    public Log(List<Game> games) {
        this.games = games;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}

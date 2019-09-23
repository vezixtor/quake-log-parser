package com.herokuapp.zeversion.quakelogparser.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer total_kills;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PlayerScore> kills;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MeansOfDeath> kills_by_means;

    public Game() {
        kills = new ArrayList<>();
        kills_by_means = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotal_kills() {
        return total_kills;
    }

    public void setTotal_kills(Integer total_kills) {
        this.total_kills = total_kills;
    }

    public List<PlayerScore> getKills() {
        return kills;
    }

    public void setKills(List<PlayerScore> kills) {
        this.kills = kills;
    }

    public List<MeansOfDeath> getKills_by_means() {
        return kills_by_means;
    }

    public void setKills_by_means(List<MeansOfDeath> kills_by_means) {
        this.kills_by_means = kills_by_means;
    }
}

package com.herokuapp.zeversion.quakelogparser.service;

import com.herokuapp.zeversion.quakelogparser.model.Game;
import com.herokuapp.zeversion.quakelogparser.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game findById(Long id) {
        return this.gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}

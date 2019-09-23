package com.herokuapp.zeversion.quakelogparser.controller;

import com.herokuapp.zeversion.quakelogparser.model.Game;
import com.herokuapp.zeversion.quakelogparser.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("{id}")
    public Game findById(@PathVariable("id") Long id) {
        return this.gameService.findById(id);
    }
}

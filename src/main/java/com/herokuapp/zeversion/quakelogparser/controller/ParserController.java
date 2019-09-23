package com.herokuapp.zeversion.quakelogparser.controller;

import com.herokuapp.zeversion.quakelogparser.model.Log;
import com.herokuapp.zeversion.quakelogparser.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/parser")
public class ParserController {

    private final LogService logService;

    @Autowired
    public ParserController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/game-log")
    public Log parserGameLog(@RequestParam("logs") MultipartFile logs) {
        return logService.parser(logs);
    }
}

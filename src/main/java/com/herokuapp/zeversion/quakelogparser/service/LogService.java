package com.herokuapp.zeversion.quakelogparser.service;

import com.herokuapp.zeversion.quakelogparser.component.QuakeLogParser;
import com.herokuapp.zeversion.quakelogparser.model.Game;
import com.herokuapp.zeversion.quakelogparser.model.Log;
import com.herokuapp.zeversion.quakelogparser.model.PlayerScore;
import com.herokuapp.zeversion.quakelogparser.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Service
public class LogService {

    private final LogRepository logRepository;

    private final QuakeLogParser quakeLogParser;

    @Autowired
    public LogService(LogRepository logRepository, QuakeLogParser quakeLogParser) {
        this.logRepository = logRepository;
        this.quakeLogParser = quakeLogParser;
    }


    public Log parser(MultipartFile logs) {
        String logBlock;
        try {
            logBlock = new String(logs.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Não foi possivel ler os logs");
        }
        Log log = quakeLogParser.parser(logBlock);
        Log logSaved = this.logRepository.save(log);
        this.printRankPerGame(logSaved.getGames());
        return logSaved;
    }

    private void printRankPerGame(List<Game> games) {
        games.forEach(game -> {
            System.out.println("\n\nRank #" + game.getId());
            game.getKills().stream()
                    .sorted(Comparator.comparingInt(PlayerScore::getKills).reversed())
                    .forEach(System.out::println);
        });
    }
}

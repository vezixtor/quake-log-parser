package com.herokuapp.zeversion.quakelogparser.component;

import com.herokuapp.zeversion.quakelogparser.model.Game;
import com.herokuapp.zeversion.quakelogparser.model.Log;
import com.herokuapp.zeversion.quakelogparser.model.MeansOfDeath;
import com.herokuapp.zeversion.quakelogparser.model.PlayerScore;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class QuakeLogParser {

    private Pattern patternKillCompile = Pattern.compile("^\\s+\\d+:\\d+\\s+Kill:\\s\\d+\\s\\d+\\s\\d+:\\s([\\w<>]+)\\skilled\\s([\\w\\s]+)\\b\\sby\\s(\\w+)");
    private Pattern patternShutdownGame = Pattern.compile("^\\s+\\d+:\\d+\\s+ShutdownGame:");

    private Log logParsered;
    private Integer total_kills;
    private Map<String, Integer> players = new HashMap<>();
    private Map<String, Integer> kills_by_means = new HashMap<>();
    private Game actualGame;

    public Log parser(String logs) {
        return this.parser(Arrays.asList(logs.split("\n")));
    }

    public Log parser(List<String> logs) {
        this.initParser();
        for (String log : logs) {
            Matcher matcher = patternKillCompile.matcher(log);
            if (matcher.find()) {
                this.computeKillLog(matcher);
            } else if (patternShutdownGame.matcher(log).find()) {
                this.onShutdownGame();
                this.initGame();
            }
        }
        return logParsered;
    }

    private void initParser() {
        logParsered = new Log();
        this.initGame();
    }

    private void initGame() {
        players.clear();
        kills_by_means.clear();
        actualGame = new Game();
        total_kills = 0;
    }

    private void onShutdownGame() {
        actualGame.setTotal_kills(total_kills);
        for (Map.Entry<String, Integer> entry : players.entrySet()) {
            actualGame.getKills().add(new PlayerScore(entry.getKey(), entry.getValue()));
        }
        for (Map.Entry<String, Integer> entry : kills_by_means.entrySet()) {
            actualGame.getKills_by_means().add(new MeansOfDeath(entry.getKey(), entry.getValue()));
        }
        logParsered.getGames().add(actualGame);
    }

    private void computeKillLog(Matcher matcher) {
        String killer = matcher.group(1);
        String killed = matcher.group(2);
        String meansOfDeath = matcher.group(3);
        total_kills++;
        if ("<world>".equals(killer)) {
            players.merge(killed, -1, (a, b) -> a + b);
        } else {
            players.merge(killer, 1, (a, b) -> a + b);
        }
        kills_by_means.merge(meansOfDeath, 1, (a, b) -> a + b);
    }
}

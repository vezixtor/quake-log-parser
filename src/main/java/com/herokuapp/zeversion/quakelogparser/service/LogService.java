package com.herokuapp.zeversion.quakelogparser.service;

import com.herokuapp.zeversion.quakelogparser.component.QuakeLogParser;
import com.herokuapp.zeversion.quakelogparser.model.Log;
import com.herokuapp.zeversion.quakelogparser.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
        return this.logRepository.save(log);
    }
}

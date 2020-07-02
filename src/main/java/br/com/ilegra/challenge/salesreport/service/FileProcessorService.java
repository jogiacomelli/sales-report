package br.com.ilegra.challenge.salesreport.service;

import br.com.ilegra.challenge.salesreport.configuration.AppProperties;
import br.com.ilegra.challenge.salesreport.strategy.DataStrategyFactory;
import br.com.ilegra.challenge.salesreport.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FileProcessorService {

    @Autowired
    private GenerateReportService reportService;

    @Autowired
    private AppProperties props;

    @Autowired
    private DataStrategyFactory strategy;

    @Async
    public void process(Path file) {

        List<String> lines = new ArrayList<>();
        try {
            if(FileUtils.fileExists(file) && FileUtils.fileIsPlainText(file)){
                lines = FileUtils.readLines(file);
            }
            log.debug("New file read. " + lines.size() + " lines");
        } catch (IOException e) {
            log.error("Error reading file " + file.toString(), e);
        }

        lines.forEach(line -> {
            String[] data = line.split(props.getFieldSeparator());
            strategy.processData(data);
        });

    }
}

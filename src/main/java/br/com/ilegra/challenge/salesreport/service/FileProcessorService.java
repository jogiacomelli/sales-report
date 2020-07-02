package br.com.ilegra.challenge.salesreport.service;

import br.com.ilegra.challenge.salesreport.configuration.AppProperties;
import br.com.ilegra.challenge.salesreport.strategy.DataStrategyFactory;
import br.com.ilegra.challenge.salesreport.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.forEach(line -> {
            String[] data = line.split(props.getFieldSeparator());
            strategy.processData(data);
        });

    }
}

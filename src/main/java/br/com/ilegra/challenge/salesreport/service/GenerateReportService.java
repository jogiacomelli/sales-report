package br.com.ilegra.challenge.salesreport.service;

import br.com.ilegra.challenge.salesreport.configuration.AppProperties;
import br.com.ilegra.challenge.salesreport.model.ReportData;
import br.com.ilegra.challenge.salesreport.model.Sale;
import br.com.ilegra.challenge.salesreport.repository.ClientRepository;
import br.com.ilegra.challenge.salesreport.repository.SaleRepository;
import br.com.ilegra.challenge.salesreport.repository.SalespersonRepository;
import br.com.ilegra.challenge.salesreport.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class GenerateReportService {

    @Autowired
    private SalespersonRepository salespersonRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AppProperties props;

    private ReportData reportData;

    private Path reportFilePath;

    @PostConstruct
    private void init() {
        Path path = Paths.get(props.getHomePath() + props.getDataFolderOut());
        this.reportFilePath = path.resolve(props.getReportFilename());
    }

    @Scheduled(fixedRate = 3500, initialDelay = 10000)
    public void generateReport() {
        ReportData newData = new ReportData(getClientData(), getSalespersonData(), getBiggestSale());

        try {
            if(!newData.equals(this.reportData)) {
                reportData = newData;
                saveReportToFile();
                log.debug("Data saved to report file: " + reportData.toString());
            }
        } catch (IOException e) {
           log.error("Error saving new data to report file.", e);
        }
    }

    private void saveReportToFile() throws IOException {
        if(!FileUtils.fileExists(this.reportFilePath)) {
            FileUtils.createFile(this.reportFilePath);
            log.debug("Report file created: " + this.reportFilePath.toString());
        }

        FileUtils.saveToFile(this.reportData.toString(), this.reportFilePath);
    }

    private Sale getBiggestSale() {
        List<Sale> orderedSales = saleRepository.getSales().stream()
                .sorted(Comparator.comparing(Sale::getTotalValue).reversed())
                .collect(Collectors.toList());

        return orderedSales.get(0);
    }

    private int getClientData() {
        return clientRepository.getClients().size();
    }

    private int getSalespersonData() {
        return salespersonRepository.getSalespersons().size();
    }

}

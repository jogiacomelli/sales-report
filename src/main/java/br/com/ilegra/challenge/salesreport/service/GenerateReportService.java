package br.com.ilegra.challenge.salesreport.service;

import br.com.ilegra.challenge.salesreport.repository.ClientRepository;
import br.com.ilegra.challenge.salesreport.repository.SaleRepository;
import br.com.ilegra.challenge.salesreport.repository.SalespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenerateReportService {

    @Autowired
    private SalespersonRepository salespersonRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ClientRepository clientRepository;

    public void generateReport() {
        System.out.println("Total of clients: " + clientRepository.getClients().size());
        System.out.println("Total of salesperson: " + salespersonRepository.getSalespersons().size());
        System.out.println("Biggest sale: ");
        saleRepository.getSales().forEach(s -> System.out.println(s.getTotalValue()));
    }

}

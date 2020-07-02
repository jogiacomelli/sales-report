package br.com.ilegra.challenge.salesreport.strategy;

import br.com.ilegra.challenge.salesreport.model.Salesperson;
import br.com.ilegra.challenge.salesreport.repository.SalespersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SalespersonDataStrategy implements DataStrategyInterface {

    @Autowired
    private SalespersonRepository salespersonRepository;

    @Override
    public void processData(String[] data) {
        long cpf = Long.parseLong(data[1]);
        String name = data[2];
        double salary = Double.parseDouble(data[3]);

        Salesperson salesperson = new Salesperson(cpf, name, salary);
        salespersonRepository.save(salesperson);

        log.debug("New salesperson added: " + salesperson.toString());

    }
}

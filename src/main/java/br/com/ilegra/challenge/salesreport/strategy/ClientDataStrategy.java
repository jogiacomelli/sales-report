package br.com.ilegra.challenge.salesreport.strategy;

import br.com.ilegra.challenge.salesreport.model.Client;
import br.com.ilegra.challenge.salesreport.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDataStrategy implements DataStrategyInterface {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void processData(String[] data) {
        long cnpj = Long.parseLong(data[1]);
        String name = data[2];
        String businessArea = data[3];

        Client client = new Client(cnpj, name, businessArea);
        clientRepository.save(client);
    }
}

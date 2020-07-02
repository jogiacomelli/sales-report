package br.com.ilegra.challenge.salesreport.repository;

import br.com.ilegra.challenge.salesreport.model.Client;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ClientRepository  {

    Set<Client> clients = new HashSet<>();

    public void save(Client client) {
        clients.add(client);
    }

    public Set<Client> getClients() {
        return clients;
    }
}

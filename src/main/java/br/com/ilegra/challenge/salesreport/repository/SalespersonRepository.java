package br.com.ilegra.challenge.salesreport.repository;

import br.com.ilegra.challenge.salesreport.model.Salesperson;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class SalespersonRepository {

    Set<Salesperson> salespersons = Collections.synchronizedSet(new HashSet<>());

    public void save(Salesperson salesperson) {
        salespersons.add(salesperson);
    }

    public Set<Salesperson> getSalespersons() {
        return salespersons;
    }

}

package br.com.ilegra.challenge.salesreport.repository;

import br.com.ilegra.challenge.salesreport.model.Sale;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class SaleRepository {
    Set<Sale> sales = new HashSet<>();

    public void save(Sale sale) {
        sales.add(sale);
    }

    public Set<Sale> getSales() {
        return sales;
    }
}

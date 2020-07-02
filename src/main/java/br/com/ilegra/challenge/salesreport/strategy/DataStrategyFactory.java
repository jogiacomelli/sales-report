package br.com.ilegra.challenge.salesreport.strategy;

import br.com.ilegra.challenge.salesreport.configuration.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataStrategyFactory {

    @Autowired
    private AppProperties props;

    @Autowired
    private ClientDataStrategy clientDataStrategy;

    @Autowired
    private SalespersonDataStrategy salespersonDataStrategy;

    @Autowired
    private SaleDataStrategy saleDataStrategy;

    public void processData(String[] data) {

        if(data.length == 4) {

            String dataType = data[0];

            if(props.getClientType().equals(dataType)) {
                clientDataStrategy.processData(data);
            } else if(props.getSalespersonType().equals(dataType)) {
                salespersonDataStrategy.processData(data);
            } else if(props.getSaleType().equals(dataType)) {
                saleDataStrategy.processData(data);
            }

        } else {
            throw new RuntimeException("Inconsistent data.");
        }
    }
}

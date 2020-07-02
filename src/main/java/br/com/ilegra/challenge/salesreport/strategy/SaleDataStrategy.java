package br.com.ilegra.challenge.salesreport.strategy;

import br.com.ilegra.challenge.salesreport.configuration.AppProperties;
import br.com.ilegra.challenge.salesreport.model.Sale;
import br.com.ilegra.challenge.salesreport.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleDataStrategy implements DataStrategyInterface {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private AppProperties props;

    @Override
    public void processData(String[] data) {
        long id = Long.parseLong(data[1]);
        String items = data[2];
        String salesperson = data[3];

        items = items.substring(1, items.length() - 1);
        double totalValue = 0.0;
        for(String item : items.split(props.getItemSeparator())) {
            String[] itemData = item.split(props.getItemFieldSeparator());
            int qtt = Integer.parseInt(itemData[1]);
            double value = Double.parseDouble(itemData[2]);
            totalValue += qtt*value;
        }

        Sale sale = new Sale(id, totalValue, salesperson);
        saleRepository.save(sale);
    }
}

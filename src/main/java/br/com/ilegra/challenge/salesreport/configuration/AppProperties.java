package br.com.ilegra.challenge.salesreport.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppProperties {

    private final String homePath = System.getProperty("user.home");

    @Value("${data.folder.in}")
    private String dataFolderIn;

    @Value("${data.folder.out}")
    private String dataFolderOut;

    @Value("${field.separator:ç}")
    private String fieldSeparator;

    @Value("${field.item.separator:,}")
    private String itemSeparator;

    @Value("${field.item.field.separator:-}")
    private String itemFieldSeparator;

    @Value("${field.type.salesperson:001}")
    private String salespersonType;

    @Value("${field.type.client:002}")
    private String clientType;

    @Value("${field.type.sale:003}")
    private String saleType;

    @Value("${data.report.filename:salesreport}")
    private String reportFilename;


    public String getHomePath() {
        return homePath;
    }

    public String getDataFolderIn() {
        return dataFolderIn;
    }

    public String getDataFolderOut() {
        return dataFolderOut;
    }

    public String getFieldSeparator() {
        return fieldSeparator;
    }

    public String getItemSeparator() {
        return itemSeparator;
    }

    public String getItemFieldSeparator() {
        return itemFieldSeparator;
    }

    public String getSalespersonType() {
        return salespersonType;
    }

    public String getClientType() {
        return clientType;
    }

    public String getSaleType() {
        return saleType;
    }

    public String getReportFilename() {
        return reportFilename;
    }
}

package br.com.ilegra.challenge.salesreport.model;

public class Sale {

    private long id;
    private double totalValue;
    private String salesperson;

    public Sale(long id, double totalValue, String salesperson) {
        this.id = id;
        this.totalValue = totalValue;
        this.salesperson = salesperson;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public String getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(String salesperson) {
        this.salesperson = salesperson;
    }
}

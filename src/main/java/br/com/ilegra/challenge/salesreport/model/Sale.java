package br.com.ilegra.challenge.salesreport.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return getId() == sale.getId() &&
                Double.compare(sale.getTotalValue(), getTotalValue()) == 0 &&
                Objects.equals(getSalesperson(), sale.getSalesperson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTotalValue(), getSalesperson());
    }
}

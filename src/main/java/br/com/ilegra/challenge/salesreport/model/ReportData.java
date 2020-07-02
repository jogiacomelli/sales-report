package br.com.ilegra.challenge.salesreport.model;

import java.util.Objects;

public class ReportData {

    private int numClients;
    private int numSalespersons;
    private Sale biggestSale;

    public ReportData(int numClients, int numSalespersons, Sale biggestSale) {
        this.numClients = numClients;
        this.numSalespersons = numSalespersons;
        this.biggestSale = biggestSale;
    }

    public int getNumClients() {
        return numClients;
    }

    public int getNumSalespersons() {
        return numSalespersons;
    }

    public Sale getBiggestSale() {
        return biggestSale;
    }

    @Override
    public String toString() {
        return "Total clients: " + getNumClients() +
                "\nTotal salespersons: " + getNumSalespersons() +
                "\nBiggest sale: " + getBiggestSale().getSalesperson() + " Value: " +
                getBiggestSale().getTotalValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportData that = (ReportData) o;
        return getNumClients() == that.getNumClients() &&
                getNumSalespersons() == that.getNumSalespersons() &&
                Objects.equals(getBiggestSale(), that.getBiggestSale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumClients(), getNumSalespersons(), getBiggestSale());
    }
}

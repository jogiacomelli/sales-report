package br.com.ilegra.challenge.salesreport.model;

import java.util.Objects;

public class Client {

    private long cnpj;
    private String name;
    private String businessArea;

    public Client(long cnpj, String name, String businessArea) {
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getCnpj() == client.getCnpj() &&
                Objects.equals(getName(), client.getName()) &&
                Objects.equals(getBusinessArea(), client.getBusinessArea());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCnpj(), getName(), getBusinessArea());
    }
}

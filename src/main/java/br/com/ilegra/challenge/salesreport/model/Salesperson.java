package br.com.ilegra.challenge.salesreport.model;

import java.util.Objects;

public class Salesperson {

    private long cpf;
    private String name;
    private double salary;

    public Salesperson(long cpf, String name, double salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salesperson that = (Salesperson) o;
        return getCpf() == that.getCpf() &&
                Double.compare(that.getSalary(), getSalary()) == 0 &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf(), getName(), getSalary());
    }

    @Override
    public String toString() {
        return "Salesperson{" +
                "cpf=" + cpf +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

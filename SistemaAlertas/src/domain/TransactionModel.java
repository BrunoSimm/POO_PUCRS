package domain;

import java.util.ArrayList;
import java.util.Date;

public abstract class TransactionModel {
    private String description;
    private double value;
    private Date payday;
    private EnumRecurrence recurrence;
    private ArrayList<Double> valueHistory;

    public TransactionModel(String description, double value, Date payday, EnumRecurrence recurrence) {
        this.description = description;
        this.value = value;
        this.payday = payday;
        this.recurrence = recurrence;
        this.valueHistory.add(value);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        valueHistory.add(value); //Adicionando novo valor ao histórico de valores.
    }

    public Date getPayday() {
        return payday;
    }

    public void setPayday(Date payday) {
        this.payday = payday;
    }

    public EnumRecurrence getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(EnumRecurrence recurrence) {
        this.recurrence = recurrence;
    }

    public ArrayList<Double> getValueHistory() {
        return valueHistory;
    }
}

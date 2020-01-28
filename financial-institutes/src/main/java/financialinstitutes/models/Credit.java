package financialinstitutes.models;


import financialinstitutes.enums.CreditState;

import java.time.LocalDateTime;

import static financialinstitutes.enums.CreditState.ACTIVE;

import static java.time.LocalDateTime.now;

public class Credit {
    private Client client;
    private BaseEmployee employee;
    private double amount;
    private CreditState state;
    private LocalDateTime firstDueDate;
    private LocalDateTime secondDueDate;

    public Credit(Client client, BaseEmployee employee, double amount) {
        this.client = client;
        this.employee = employee;
        this.amount = amount;
        this.state = ACTIVE;
        this.firstDueDate = now();
        this.secondDueDate = firstDueDate.plusMonths(1);
    }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    public BaseEmployee getEmployee() { return employee; }

    public void setEmployee(BaseEmployee employee) { this.employee = employee; }

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }

    public CreditState getState() { return state; }

    public void setState(CreditState state) { this.state = state; }

    public LocalDateTime getFirstDueDate() { return firstDueDate; }

    public void setFirstDueDate(LocalDateTime firstDueDate) { this.firstDueDate = firstDueDate; }

    public LocalDateTime getSecondDueDate() { return secondDueDate; }

    public void setSecondDueDate(LocalDateTime secondDueDate) { this.secondDueDate = secondDueDate; }

    @Override
    public String toString() {
        return "Credit{" +
                "amount=" + amount +
                ", state=" + state +
                ", firstDueDate=" + firstDueDate +
                ", secondDueDate=" + secondDueDate +
                '}';
    }
}

package financialinstitutes.models;


import financialinstitutes.enums.Country;
import financialinstitutes.enums.Reputation;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static financialinstitutes.enums.Reputation.GOOD;


public class Client extends Person {
    private static final Logger Log = Logger.getLogger(Client.class);

    private double income;
    private Reputation reputation;
    private List<Credit> credits;

    public Client() { }

    public Client(String firstName, String lastName, int idNumber, Country country, double income) {
        super(firstName, lastName, idNumber, country);
        this.income = income;
        this.reputation = GOOD;
        this.credits = new ArrayList<>();
    }

    public double getIncome() { return income; }

    public void setIncome(double income) { this.income = income; }

    public Reputation getReputation() {
        return reputation;
    }

    public void addCredit(Credit credit) {
        credits.add(credit);
    }

    public void setReputation(Reputation reputation) { this.reputation = reputation; }

    public List<Credit> getCredits() { return credits; }

    public void setCredits(List<Credit> credits) { this.credits = credits; }

    @Override
    public String toString() {
        return "Client{" +
                "income=" + income +
                ", reputation=" + reputation +
                ", credits=" + credits +
                '}';
    }
}
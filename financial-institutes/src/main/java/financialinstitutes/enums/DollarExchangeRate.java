package financialinstitutes.enums;

public enum DollarExchangeRate {
    ARG_RATE(59.76),
    RU_RATE(62.74);

    private double rate;

    private DollarExchangeRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}

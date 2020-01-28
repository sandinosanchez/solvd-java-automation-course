package financialinstitutes.models;


import financialinstitutes.enums.Country;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int idNumber;
    protected Country country;

    public Person(){}

    public Person(String firstName, String lastName, int idNumber, Country country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.country = country;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getIdNumber() { return idNumber; }

    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }

    public Country getCountry() { return country; }

    public void setCountry(Country country) { this.country = country; }
}

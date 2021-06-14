package kg.megacom.Models;

public class Depositor {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private long passNumber;

    public Depositor() {
    }

    public Depositor(String lastName) {
        this.lastName = lastName;
    }

    public Depositor(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Depositor(String firstName, String lastName, String middleName, long passNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.passNumber = passNumber;
    }

    public Depositor(int id, String firstName, String lastName, String middleName, long passNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.passNumber = passNumber;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public long getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(long passNumber) {
        this.passNumber = passNumber;
    }

    @Override
    public String toString() {
        return  " id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", passNumber=" + passNumber +
                '}';
    }
}

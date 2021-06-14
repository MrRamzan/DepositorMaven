package kg.megacom.Methods;

import kg.megacom.Models.Depositor;
import kg.megacom.Models.Street;

public class DepositorByAddress {
    private Depositor depositor;
    private Street street;

    public DepositorByAddress(Depositor depositor, Street street) {
        this.depositor = depositor;
        this.street = street;
    }

    public Depositor getDepositor() {
        return depositor;
    }

    public void setDepositor(Depositor depositor) {
        this.depositor = depositor;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return  "DepositorByAddress{" + "\n" +
                "last name -" + depositor.getLastName()+ "\n" +
                "first name -" + depositor.getFirstName() + "\n"+
                "middle name -" + depositor.getMiddleName() + "\n" +
                "street=" + street.getName() + "\n" +
                "----------------------------" + "\n" ;
    }
}

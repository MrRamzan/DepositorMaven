package kg.megacom.Methods;

import kg.megacom.Models.Depositor;

public class AlphabeticalList {
    private Depositor depositor;

    public AlphabeticalList(Depositor depositor) {
        this.depositor = depositor;
    }

    public Depositor getDepositor() {
        return depositor;
    }

    public void setDepositor(Depositor depositor) {
        this.depositor = depositor;
    }

    @Override
    public String toString() {
        return "AlphabeticalList{" + "\n" +
                "last name -" + depositor.getLastName()+ "\n" +
                "first name -" + depositor.getFirstName() + "\n"+
                "middle name -" + depositor.getMiddleName() + "\n"+
                "-------------------------------" + "\n";
    }
}

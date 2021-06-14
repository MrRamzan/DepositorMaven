package kg.megacom.Methods;

import kg.megacom.Models.Depositor;

public class ChangingTheCase {
    private Depositor depositor;

    public ChangingTheCase(Depositor depositor) {
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
        return "ChangingTheCase{" +
                "depositor=" + depositor.getLastName() + " " + depositor.getFirstName() + " " + depositor.getMiddleName() +"\n" +
                "--------------------------------" + "\n";
    }
}

package kg.megacom.Methods;

import kg.megacom.Models.Depositor;
import kg.megacom.Models.Operation;

public class AmountOfDeposit {
    private Depositor depositor;
    private Operation operation;

    public AmountOfDeposit() {
    }

    public AmountOfDeposit(Depositor depositor, Operation operation) {
        this.depositor = depositor;
        this.operation = operation;
    }

    public Depositor getDepositor() {
        return depositor;
    }

    public void setDepositor(Depositor depositor) {
        this.depositor = depositor;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "AmountOfDeposit" +"\n" +
                "first Name - " + depositor.getFirstName()+ "\n" +
                "last Name - " + depositor.getLastName() + "\n" +
                "middle Name - " + depositor.getMiddleName()+"\n"+
                "deposit sum=" + operation.getDepositSum() + "\n"+
                 "---------------------------" + "\n";
    }
}
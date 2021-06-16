package kg.megacom.Methods;

import kg.megacom.Models.Depositor;
import kg.megacom.Models.Operation;

public class CountOfDeposit {
    private Depositor depositor;
    private Operation operation;

    public CountOfDeposit(Depositor depositor, Operation operation) {
        this.depositor = depositor;
        this.operation = operation;
    }

    public CountOfDeposit() {
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
        return "CountOfDeposit{" +
                "last name -" + depositor.getLastName()+ "\n" +
                "first name -" + depositor.getFirstName() + "\n"+
                "operation -" + operation.getDepositSum() + "\n" +
                "-------------------------------" + "\n";
    }
}

package kg.megacom.Methods;

import kg.megacom.Models.Depositor;
import kg.megacom.Models.Operation;
import kg.megacom.Models.TypeOfOperation;

public class StateRequest {
    private Depositor depositor;
    private TypeOfOperation typeOfOperation;
    private Operation operation;

    public StateRequest(Depositor depositor, TypeOfOperation typeOfOperation, Operation operation) {
        this.depositor = depositor;
        this.typeOfOperation = typeOfOperation;
        this.operation = operation;
    }

    public Depositor getDepositor() {
        return depositor;
    }

    public void setDepositor(Depositor depositor) {
        this.depositor = depositor;
    }

    public TypeOfOperation getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(TypeOfOperation typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "StateRequest{" +
                "last name -" + depositor.getLastName()+ "\n" +
                "first name -" + depositor.getFirstName() + "\n"+
                "middle name -" + depositor.getMiddleName() + "\n" +
                "typeOfOperation=" + typeOfOperation.getDateOfOperation()+ "\n" +
                "operation=" + operation.getDepositSum() +"\n"+
                "----------------------------------" +"\n";
    }
}

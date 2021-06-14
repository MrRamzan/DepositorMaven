package kg.megacom.Models;

import java.util.Date;

public class TypeOfOperation {
    private int id;
    private Date dateOfOperation;
    private Double sumOfOperation;
    private Account account;
    private String typeOfOperation;

    public TypeOfOperation(Date dateOfOperation) {
        this.dateOfOperation = dateOfOperation;
    }

    public TypeOfOperation(Date dateOfOperation, double sumOfOperation) {
        this.dateOfOperation = dateOfOperation;
        this.sumOfOperation = sumOfOperation;
    }

    public TypeOfOperation(int id, Date dateOfOperation, Double sumOfOperation, Account account, String typeOfOperation) {
        this.id = id;
        this.dateOfOperation = dateOfOperation;
        this.sumOfOperation = sumOfOperation;
        this.account = account;
        this.typeOfOperation = typeOfOperation;

    }

    public int getId() {
        return id;
    }

    public Date getDateOfOperation() {
        return dateOfOperation;
    }

    public void setDateOfOperation(Date dateOfOperation) {
        this.dateOfOperation = dateOfOperation;
    }

    public Double getSumOfOperation() {
        return sumOfOperation;
    }

    public void setSumOfOperation(Double sumOfOperation) {
        this.sumOfOperation = sumOfOperation;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    @Override
    public String toString() {
        return "TypeOfOperation{" +
                "id=" + id +
                ", dateOfOperation=" + dateOfOperation +
                ", sumOfOperation=" + sumOfOperation +
                ", account=" + account +
                ", typeOfOperation='" + typeOfOperation + '\'' +
                '}'+"\n";
    }
}

package kg.megacom.Methods;

import kg.megacom.Models.*;

public class DepositorInfo {

    private Depositor depositor;
    private Account account;
    private Street street;
    private House house;
    private TypeOfOperation typeOfOperation;
    private Operation operation;
    private Currencys currencys;
    private Deposit deposit;

    public DepositorInfo() {
    }

    public DepositorInfo(Operation operation) {
        this.operation = operation;
    }

    public DepositorInfo(Depositor depositor, Account account, Street street) {
        this.depositor = depositor;
        this.account = account;
        this.street = street;
    }

    public DepositorInfo(Depositor depositor, Account account, Street street, House house, TypeOfOperation typeOfOperation, Operation operation) {
        this.depositor = depositor;
        this.account = account;
        this.street = street;
        this.house = house;
        this.typeOfOperation=typeOfOperation;
        this.operation = operation;
    }

    public DepositorInfo(Depositor depositor, Account account, Street street, House house, Operation operation, Currencys currencys, Deposit deposit) {
        this.depositor = depositor;
        this.account = account;
        this.street = street;
        this.house = house;
        this.operation = operation;
        this.currencys = currencys;
        this.deposit = deposit;
    }

    public Depositor getDepositor() {
        return depositor;
    }

    public void setDepositor(Depositor depositor) {
        this.depositor = depositor;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Currencys getCurrencys() {
        return currencys;
    }

    public void setCurrencys(Currencys currencys) {
        this.currencys = currencys;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public TypeOfOperation getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(TypeOfOperation typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    @Override
    public String toString() {
        return "DepositorInfo {" +
                "depositor - " + depositor +"\n"+
                " account =" + account.getAccountNum()+ " " +"\n"+
                " street =" + street.getName() + " " +"\n"+
                " house =" + house.getHouseNumber() + " " +"\n"+
                " dateOfOperation =" + typeOfOperation.getDateOfOperation() + " " +"\n"+
                " depositSum =" + operation.getDepositSum() + " " +"\n"+
                " sumOfOperation =" + typeOfOperation.getSumOfOperation() + " " +"\n"+
                   "----------------------------------" +"\n";

    }

}

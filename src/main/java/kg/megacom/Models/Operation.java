package kg.megacom.Models;

import java.util.Date;

public class Operation {
    private  int id;
    private Account account;
    private Deposit deposit;
    private  int periodOfStorage;
    private Date startDate;
    private  Date endDate;
    private double depositSum;

    public Operation(double depositSum) {
        this.depositSum = depositSum;
    }

    public Operation(int id, Account account, Deposit deposit, int periodOfStorage, Date startDate, Date endDate, double depositSum) {
        this.id = id;
        this.account = account;
        this.deposit = deposit;
        this.periodOfStorage = periodOfStorage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.depositSum = depositSum;
    }

    public long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public int getPeriodOfStorage() {
        return periodOfStorage;
    }

    public void setPeriodOfStorage(int periodOfStorage) {
        this.periodOfStorage = periodOfStorage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDepositSum() {
        return depositSum;
    }

    public void setDepositSum(double depositSum) {
        this.depositSum = depositSum;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", account=" + account +
                ", deposit=" + deposit +
                ", periodOfStorage=" + periodOfStorage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", depositSum=" + depositSum +
                '}'+ "\n";
    }
}

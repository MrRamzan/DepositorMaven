package kg.megacom.Models;

public class Account {
    private int id;
    private long accountNum;
    private  double sumInAccount;
    private Depositor depositor;

    public Account() {
    }

    public Account(long accountNum) {
        this.accountNum = accountNum;
    }

    public Account(int id, long accountNum, double sumInAccount, Depositor depositor) {
        this.id = id;
        this.accountNum = accountNum;
        this.sumInAccount = sumInAccount;
        this.depositor = depositor;
    }

    public long getId() {
        return id;
    }

    public long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(long accountNum) {
        this.accountNum = accountNum;
    }

    public double getSumInAccount() {
        return sumInAccount;
    }

    public void setSumInAccount(double sumInAccount) {
        this.sumInAccount = sumInAccount;
    }

    public Depositor getDepositor() {
        return depositor;
    }

    public void setDepositor(Depositor depositor) {
        this.depositor = depositor;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNum=" + accountNum +
                ", sumInAccount=" + sumInAccount +
                ", depositor=" + depositor +
                '}';
    }
}

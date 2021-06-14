package kg.megacom.Models;

public class Deposit {
    private int id;
    private  String name;
    private int period;
    private double procent;
    private Currencys currencys;

    public Deposit() {
    }

    public Deposit(String name, int period, double procent) {
        this.name = name;
        this.period = period;
        this.procent = procent;
        this.currencys = currencys;
    }

    public Deposit(int id, String name, int period, double procent) {
        this.id = id;
        this.name = name;
        this.period = period;
        this.procent = procent;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getProcent() {
        return procent;
    }

    public void setProcent(double procent) {
        this.procent = procent;
    }

    public Currencys getCurrencys() {
        return currencys;
    }

    public void setCurrencys(Currencys currencys) {
        this.currencys = currencys;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", period=" + period +
                ", procent=" + procent +
                '}'+ "\n";
    }
}

package kg.megacom.Models;

public class Currencys {
    private int id;
    private String currencyName;

    public Currencys() {
    }

    public Currencys(int id, String currencyName) {
        this.id = id;
        this.currencyName = currencyName;
    }

    public long getId() {
        return id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public String toString() {
        return "Currencys{" +
                "id=" + id +
                ", currencyName='" + currencyName + '\'' +
                '}';
    }
}

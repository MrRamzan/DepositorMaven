package kg.megacom.Models;

public class House {
    private  int id;
    private  int houseNumber;

    public House(int houseNum) {
        this.houseNumber = houseNumber;
    }

    public House(int id, int houseNumber) {
        this.id = id;
        this.houseNumber = houseNumber;
    }

    public long getId() {
        return id;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", houseNumber=" + houseNumber +
                '}';
    }
}

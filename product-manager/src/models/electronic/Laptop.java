package models.electronic;

public class Laptop extends Electronic{
    private int ram;

    public Laptop(int code, String name, double price, String manufacturer, int quantity, int ram) {
        super(code, name, price, manufacturer, quantity);
        this.ram = ram;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

}

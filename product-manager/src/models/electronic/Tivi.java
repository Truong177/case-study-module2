package models.electronic;

public class Tivi extends Electronic{
    private int size ;

    public Tivi(int code, String name, double price, String manufacturer, int quantity, int size) {
        super(code, name, price, manufacturer, quantity);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

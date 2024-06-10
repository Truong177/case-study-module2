package models.electronic;

public class Electronic {
    private int code;
    private String name;
    private  double price;
    private String manufacturer;
    private int quantity;

    public Electronic() {
    }

    public Electronic(int code, String name, double price, String manufacturer, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }
    public Electronic(Electronic other) {
        this.code = other.code;
        this.name = other.name;
        this.price = other.price;
        this.manufacturer = other.manufacturer;
        this.quantity = other.quantity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ElectronicProduct{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

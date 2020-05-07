package ch.heigvd.gen2019;

public class Product {
    private String code;
    private Color color;
    private Size size;
    private double price;
    private Currency currency;

    public Product(String code, Color color, Size size, double price, Currency currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }
}
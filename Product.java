public class Product {

    private String name;
    private String code;
    private double price;
    private int quantity;

    public Product(String name, String code, double price, int quantity) {
        this.name = name;
        this.code = code;
        setPrice(price);
        setQuantity(quantity);
    }

    public String getName() { return name; }
    public String getCode() { return code; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }

    public void setPrice(double price) {
        if(price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public String toCSV() {
        return name + "," + code + "," + price + "," + quantity;
    }

    public String toJSON() {
        return String.format("{\"name\":\"%s\", \"code\":\"%s\", \"price\":%.2f, \"quantity\":%d}",
                name, code, price, quantity);
    }

    public String toXML() {
        return String.format("<Product><Name>%s</Name><Code>%s</Code><Price>%.2f</Price><Quantity>%d</Quantity></Product>",
                name, code, price, quantity);
    }
}

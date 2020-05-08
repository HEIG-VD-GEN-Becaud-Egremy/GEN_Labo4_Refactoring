package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

import static ch.heigvd.gen2019.FormattableToJSON.appendField;

public class Order implements FormattableToJSON {
    private List<Product> products = new ArrayList<Product>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return id;
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void AddProduct(Product product) {
        products.add(product);
    }

    @Override
    public void toJSON(StringBuffer sb) {
        sb.append("{");
        appendField(sb, "id", getOrderId());
        sb.append(", ");
        sb.append("\"products\": [");
        for (int j = 0; j < getProductsCount(); j++) {
            getProduct(j).toJSON(sb);
        }

        if (getProductsCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]");
        sb.append("}, ");
    }
}

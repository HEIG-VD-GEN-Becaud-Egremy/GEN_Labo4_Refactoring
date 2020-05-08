package ch.heigvd.gen2019;

import java.util.List;

public class OrdersWriter {
    private List<Order> orders;

    public OrdersWriter(List<Order> orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer();

        FormattableToJSON.appendListOfFormattableToJSON(sb, orders);

        return sb.toString();
    }
}
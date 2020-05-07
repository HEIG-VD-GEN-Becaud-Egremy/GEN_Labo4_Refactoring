package ch.heigvd.gen2019;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
            sb.append("{");
            appendField(sb, "id", order.getOrderId());
            sb.append(", ");
            sb.append("\"products\": [");
            for (int j = 0; j < order.getProductsCount(); j++) {
                getProductContents(sb, order.getProduct(j));
            }

            if (order.getProductsCount() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }

            sb.append("]");
            sb.append("}, ");
        }

        if (orders.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

    private void appendField(StringBuffer sb, String fieldName, Object object) {
        sb.append('\"');
        sb.append(fieldName);
        sb.append("\": ");
        sb.append(object);
    }

    private void appendField(StringBuffer sb, String fieldName, String str) {
        sb.append('\"');
        sb.append(fieldName);
        sb.append("\": \"");
        sb.append(str);
        sb.append("\"");
    }

    private void getProductContents(StringBuffer sb, Product product) {
        sb.append("{");
        appendField(sb, "code", product.getCode());
        sb.append(", ");
        appendField(sb, "color", product.getColor().toString());
        sb.append(", ");

        if (product.getSize() != Size.NONE) {
            appendField(sb, "size", product.getSize().toString());
            sb.append(", ");
        }

        appendField(sb, "price", product.getPrice());
        sb.append(", ");
        appendField(sb, "currency", product.getCurrency().toString());
        sb.append("}, ");
    }

}
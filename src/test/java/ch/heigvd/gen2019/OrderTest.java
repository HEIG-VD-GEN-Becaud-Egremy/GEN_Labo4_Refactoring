package ch.heigvd.gen2019;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {
    List<Order> orders = new ArrayList<>();
    Order order111 = new Order(111);

    @BeforeEach
    public void SetupOneOrder() {
        orders.add(order111);
    }

    @Test
    public void NoOrder() {
        Assertions.assertEquals("{\"orders\": []}", FormattableToJSON.formatToString("orders", new ArrayList<>()));
    }

    @Test
    public void OneOrder() {
        String order111 = "{\"id\": 111, \"products\": []}";
        Assertions.assertEquals("{\"orders\": [" + order111 + "]}", FormattableToJSON.formatToString("orders", orders));
    }

    @Test
    public void TwoOrders() {
        orders.add(new Order(222));

        String order111Json = JsonOrder111WithProduct("");
        String order222Json = "{\"id\": 222, \"products\": []}";
        Assertions.assertEquals("{\"orders\": [" + order111Json + ", " + order222Json + "]}", FormattableToJSON.formatToString("orders", orders));
    }

    @Test
    public void OneOrderWithOneProduct() {
        order111.AddProduct(new Product("Shirt", Color.BLUE, Size.M, 2.99, Currency.TWD));

        String order111Json = JsonOrder111WithProduct("{\"code\": \"Shirt\", \"color\": \"blue\", \"size\": \"M\", \"price\": 2.99, \"currency\": \"TWD\"}");
        Assertions.assertEquals("{\"orders\": [" + order111Json + "]}", FormattableToJSON.formatToString("orders", orders));
    }

    @Test
    public void OneOrderWithOneProductNoSize() {
        order111.AddProduct(new Product("Pot", Color.RED, Size.NONE, 16.50, Currency.SGD));

        String order111Json = JsonOrder111WithProduct("{\"code\": \"Pot\", \"color\": \"red\", \"price\": 16.5, \"currency\": \"SGD\"}");
        Assertions.assertEquals("{\"orders\": [" + order111Json + "]}", FormattableToJSON.formatToString("orders", orders));
    }

    private String JsonOrder111WithProduct(String productJson) {
        return "{\"id\": 111, \"products\": [" + productJson + "]}";
    }
}

package pack.com.Gg.main;

import pack.com.Gg.model.*;
import pack.com.Gg.service.OrderService;

public class Main {
    public static void main(String[] args) {
        User u=new User("test_user", "dubai");
        Product p=new Product("keyboard", 800);
        Order o=new Order(u, p, 4);
        OrderService service=new OrderService();
        service.placeOrder(o);

    }
}

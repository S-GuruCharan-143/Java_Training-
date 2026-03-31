import java.util.*;

// ================= ENUM =================
enum OrderStatus {
    PLACED,
    PREPARING,
    OUT_FOR_DELIVERY,
    DELIVERED
}

// ================= BASE CLASS =================
class Person {
    String name;
    String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

// ================= USER =================
class Customer extends Person {
    int id;
    Address address;

    public Customer(int id, String name, String phone, Address address) {
        super(name, phone);
        this.id = id;
        this.address = address;
    }
}

// ================= DELIVERY AGENT =================
class DeliveryAgent extends Person {
    int id;
    boolean available = true;

    public DeliveryAgent(int id, String name, String phone) {
        super(name, phone);
        this.id = id;
    }
}

// ================= ADDRESS =================
class Address {
    String city;
    String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}

// ================= MENU ITEM =================
class MenuItem {
    int id;
    String name;
    double price;

    public MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

// ================= RESTAURANT =================
class Restaurant {
    int id;
    String name;
    List<MenuItem> menu;

    public Restaurant(int id, String name, List<MenuItem> menu) {
        this.id = id;
        this.name = name;
        this.menu = menu;
    }

    public void showMenu() {
        for (MenuItem item : menu) {
            System.out.println(item.name + " - ₹" + item.price);
        }
    }
}

// ================= ORDER =================
class Order {
    int id;
    Customer customer;
    Restaurant restaurant;
    List<MenuItem> items;
    OrderStatus status;
    DeliveryAgent agent;

    public Order(int id, Customer customer, Restaurant restaurant, List<MenuItem> items) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = items;
        this.status = OrderStatus.PLACED;
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.price;
        }
        return total;
    }
}

// ================= PAYMENT INTERFACE =================
interface Payment {
    void pay(double amount);
}

// ================= PAYMENT IMPLEMENTATIONS =================
class UpiPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Card");
    }
}

// ================= SERVICES =================
class OrderService {
    int orderCounter = 1;

    public Order createOrder(Customer c, Restaurant r, List<MenuItem> items) {
        Order order = new Order(orderCounter++, c, r, items);
        System.out.println("Order Created with ID: " + order.id);
        return order;
    }

    public void updateStatus(Order order, OrderStatus status) {
        order.status = status;
        System.out.println("Order " + order.id + " -> " + status);
    }
}

class DeliveryService {
    List<DeliveryAgent> agents;

    public DeliveryService(List<DeliveryAgent> agents) {
        this.agents = agents;
    }

    public DeliveryAgent assignAgent(Order order) {
        for (DeliveryAgent agent : agents) {
            if (agent.available) {
                agent.available = false;
                order.agent = agent;
                System.out.println("Assigned Agent: " + agent.name);
                return agent;
            }
        }
        System.out.println("No agent available");
        return null;
    }
}

// ================= MAIN APP =================
public class FoodDeliveryApp {
    public static void main(String[] args) {

        // Create Menu
        MenuItem burger = new MenuItem(1, "Burger", 120);
        MenuItem pizza = new MenuItem(2, "Pizza", 250);

        List<MenuItem> menu = Arrays.asList(burger, pizza);

        // Create Restaurant
        Restaurant restaurant = new Restaurant(1, "Food Palace", menu);

        // Create Customer
        Customer customer = new Customer(1, "Nivetha", "9999999999",
                new Address("Chennai", "OMR"));

        // Create Delivery Agents
        DeliveryAgent agent1 = new DeliveryAgent(1, "Ravi", "8888888888");
        DeliveryAgent agent2 = new DeliveryAgent(2, "Arun", "7777777777");

        List<DeliveryAgent> agents = Arrays.asList(agent1, agent2);

        // Services
        OrderService orderService = new OrderService();
        DeliveryService deliveryService = new DeliveryService(agents);

        // Place Order
        List<MenuItem> orderItems = Arrays.asList(burger, pizza);
        Order order = orderService.createOrder(customer, restaurant, orderItems);

        // Calculate Total
        double total = order.calculateTotal();
        System.out.println("Total Amount: ₹" + total);

        // Payment
        Payment payment = new UpiPayment();
        payment.pay(total);

        // Assign Delivery
        deliveryService.assignAgent(order);

        // Update Order Status
        orderService.updateStatus(order, OrderStatus.PREPARING);
        orderService.updateStatus(order, OrderStatus.OUT_FOR_DELIVERY);
        orderService.updateStatus(order, OrderStatus.DELIVERED);
    }
}
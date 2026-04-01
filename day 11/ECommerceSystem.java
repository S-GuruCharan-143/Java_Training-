class ProductOutOfStock extends Exception{
    public ProductOutOfStock(String str){
        super(str);
    }
}
class PaymentFailed extends Exception{  
    public PaymentFailed(String str){
        super(str);
    }
}
class OrderProcessingFailed extends Exception{
    public OrderProcessingFailed(String str){
        super(str);
    }
}
class InvalidAddress extends Exception{
    public InvalidAddress(String str){
        super(str);
    }
}
class Product{
    Product(String name,int stock, double price){
        this.name=name;
        this.stock=stock;
        this.price=price;
    }
    String name;
    int stock;
    double price;
}
class User{
    User(String name,String address){
        this.name=name;
        this.address=address;
    }
    String name;
    String address;
}
class Order{
    Product product;
    User user;
    int quantity;
    Order(Product product,User user,int quantity){
        this.product=product;
        this.user=user;
        this.quantity=quantity;
    }
}
class OrderService{
    public void placeOrder(Order order,String address)throws ProductOutOfStock,PaymentFailed,OrderProcessingFailed,InvalidAddress{
        if(order.product.stock<order.quantity) throw new ProductOutOfStock("product is gone out of stock");
        if(Math.random()<0.3) throw new PaymentFailed("The payment is failed, try again later");
        if(Math.random()<0.2) throw new OrderProcessingFailed("The processing of order has failed");
        if(!order.user.address.equals(address)) throw new InvalidAddress("The address is invaild/incorrect");
        order.product.stock-=order.quantity;
        System.out.println("Order placed successfully");
    }
}
public class ECommerceSystem {
    public static void main(String[] agrs){
        Product pro=new Product("Pen", 6,10);
        User userr=new User("dhepp", "vellore");
        Order ord=new Order(pro, userr, 2);
        OrderService ser=new OrderService();
        try{
            ser.placeOrder(ord, "vellore");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }   
}

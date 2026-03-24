class product{
    int id;
    String name;
    double price;
    int quantity;
    product(int id,String name,double price,int quantity){
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public double getTotalPrice(){
        return price*quantity;
    }
    public void display(){
        System.out.print(id+"\t");
        System.out.print(name+"\t\t");
        System.out.print(price+"\t");
        System.out.println(quantity);
    }
}

public class shop_cart {
    public static void main(String[] args) {
        
    product[] cart=new product[3];
        cart[0]=new product(1,"tissue",5,10);
        cart[1]=new product(2, "shampoo", 10, 3);
        cart[2]=new product(3, "soap", 5,5);
       double grand=0;
       System.out.println("id\t"+"name\t\t"+"price\t"+"quantity\n");
        for(int i=0;i<3;i++){
            cart[i].display();
            grand+=cart[i].getTotalPrice();
        }
        System.out.println("\ngrand total:"+grand);
    }
}
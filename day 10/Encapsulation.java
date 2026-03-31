class BankAccount{
    private double balance;
    public void setBalance(double balance){ //setters
        if(balance>0){
            this.balance=balance;
        }
        else{
            System.out.println("input not valid");
        }
    }
    public double getBalance(){ //getters
        System.out.println("balance:");
        return balance;
    }
    public void withdraw(int amount){
        if(balance>=amount && amount>0){
        balance-=amount;
        System.out.println("amount debited: "+amount);
        }
        else{
            System.out.println("invaild amount");
        }
    }
    public void deposit(int amount){
        if(amount>0){
            balance+=amount;
            System.out.println("amount deposited: "+amount);
        }
        else{
            System.out.println("invalid amount");
        }
    }
}
public class Encapsulation {
    public static void main(String[] args) {
        BankAccount bk=new BankAccount();
        //bk.balance+=1000;
        bk.setBalance(2000);
        //System.out.println(bk.balance);
        //cannot access the private instance balance directly
        System.out.println(bk.getBalance());
        bk.withdraw(1500);
        System.out.println(bk.getBalance());
        bk.deposit(5000);
        System.out.println(bk.getBalance());
    }
}

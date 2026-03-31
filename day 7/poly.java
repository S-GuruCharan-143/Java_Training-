class calculator{
    int add(int n,int m){
        return n+m;
    }
    int add(int a,int b,int c){
        return a+b+c;
    }
    double add(double n,double m){
        return n+m;
    }
}

public class poly {
    public static void main(String[] args){
        calculator cal=new calculator();
        System.out.println(cal.add(10,20.0));
    }
}

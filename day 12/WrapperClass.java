public class WrapperClass{
    public static Integer test1(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) {
        Integer b=Integer.valueOf(23);
       // System.out.println(b);
        Integer c=Integer.valueOf("123");// returns type->object(Integer)
       // System.out.println(c);
        Integer d=Integer.parseInt("098");// return type->int(int)
        //System.out.println(d); 
       // System.out.println(test1("133"));
        int a=b;//unboxing
       // System.out.println(Integer.valueOf(a)); //autoboxing
        Integer x=200;
        Integer y=200;
        //System.out.println(x==y);
        //System.out.println(x.equals(y));

    }
}
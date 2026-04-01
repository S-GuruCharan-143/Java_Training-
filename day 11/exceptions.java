public class exceptions{
    public static void main(String[] args) {
        try{
            int a=19;
            int b=0;
            //int c=a/b;
            String s=null;
            System.out.println(s.length());
        } catch(ArithmeticException e){
            System.out.println("cant divide by 0");
        }
        catch(NullPointerException e){
            System.out.println("string is null");
        }
        catch(Exception e){
            System.out.println(e);
        }finally{
            System.out.println("finally block alwayss execute");
        }
    }
}
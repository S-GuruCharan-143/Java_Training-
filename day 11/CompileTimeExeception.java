public class CompileTimeExeception {
    public static void main(String[] args){
        Thread T=new Thread(()->{
        try{
            System.out.println("thread sleep");
            Thread.sleep(5000);
            System.out.println("thread wake");
        }catch(InterruptedException e){
            //todo: handle exception
            System.out.println("sleep interrupted");
            }
        });
        T.start();
        try{
            Thread.sleep(10000);
        }catch(Exception e){
            //todo: handle exceptions
            System.out.println("not T");
        }
        T.interrupt();
    }   
}
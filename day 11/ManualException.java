class InvaildAgeException extends Exception{
    public void InvalidageException(String msg){
        super(msg);
    }
}
public class ManualException {
    static void checkAge(int age) throws InvaildAgeException{
        if(age<18){
            throw new InvaildageException("Age is lesser than 18");
        }
        else{
            System.out.println("Eligible age");
        }
    }
}

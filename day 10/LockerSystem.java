class Locker{
    private int LockerId;
    private int pin;
    private boolean isLocked;
    private String item;
    Locker(int lockerid,int pin){
        this.LockerId=lockerid;
        this.pin=pin;
        isLocked=true;
    }
    public void StoreItem(String item,int pin){
        if(this.pin==pin){
            if(!isLocked){
                this.item=item;
                System.out.println("item stored: "+item);
            }        
            else{
                System.out.println("locker is locked");
            }
        }
        else{
            System.out.println("entered pin is wrong");
        }
    }
    public void retrieveItem(int pin){
        if(this.pin==pin){
            if(!isLocked && item!=null){
                System.out.println("retrieved item: "+item);
                item=null;
            }
            else if(item==null){
                System.out.println("locked is empty");
            }
            else{
                System.out.println("locker is locked");
            }
        }
        else{
            System.out.println("the pin is wrong");
        }
    }
    public void Lock(){
        System.out.println("locker locked");
        isLocked=true;
    }
    public void unLock(int pin){
        if(this.pin==pin){
            System.out.println("locker unlocked");
            isLocked=false;
        }
        else{
            System.out.println("wrong pin");
        }
    }
    
}
public class LockerSystem {
    public static void main(String[] args){
        Locker lc=new Locker(101,1430);
        lc.unLock(1430);
        lc.StoreItem("lap", 1430);
        lc.retrieveItem(1430);
        lc.Lock();
    }
}

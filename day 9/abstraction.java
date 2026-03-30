abstract class smartDevices {
    abstract void turnOn();
    abstract void turnOff();    
    void device_info(){
        //concrete method
        System.out.println("it is a device");
    }
}
class tubeLight extends smartDevices{
    //must define all the methods inheritened from the abstract class.
    void turnOn(){
        System.out.print("light on\n");
    }
    void turnOff(){
        System.out.println("light off");
    }
}
public class abstraction {
    public static void main(String[] args) {
        smartDevices dev=new tubeLight();
        //cannot create obj for abstract classes
        dev.turnOn();
        dev.turnOff(); 
        dev.device_info();

    }   
}

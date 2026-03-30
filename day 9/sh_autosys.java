abstract class devices{
    String name;
    abstract void turnOn();
    abstract void turnOff();
    
}
class lightt extends devices{
    void turnOn(){
        System.out.println("light is turned on");
    }
    void turnOff(){
        System.out.println("light is turned off");
    }
}
class acc extends devices{
    void turnOn(){
        System.out.println("ac is turned on");
    }
    void turnOff(){
        System.out.println("ac is turned off");
    }
}
interface trigger{
    boolean isTriggered();
}
class motion_trigger implements trigger{
    boolean motion;
    motion_trigger(boolean motion){
        this.motion=motion;
    }
    public boolean isTriggered(){
        if(motion){
        System.out.println("motion triggered");
        return true;
        }
        return false;
    }
}
class temp_trigger implements trigger{
    int temp;
    temp_trigger(int temp){
        this.temp=temp;
    }
    public boolean isTriggered(){
        if(temp>30){
            System.out.println("temp exceeded");
            return true;
        }
        return false;
    }
}
class time_trigger implements trigger{
    int time;
    time_trigger(int time){
        this.time=time;
    }
    public boolean isTriggered(){
        if(time>=19){
            System.out.println("time reached");
            return true;
        }
        return false;
    }
}
interface action{
    void execute();
}
class turnOnAction implements action{
    devices dev;
    turnOnAction(devices dev){
        this.dev=dev;
    }
    public void execute(){
        dev.turnOn();
    }
}
class turnOffAction implements action{
    devices dev;
    turnOffAction(devices dev){
        this.dev=dev;
    }
    public void execute(){
        dev.turnOff();
    }
}
class Rule{
    trigger tri;
    action act;
    Rule(trigger t,action act){
        this.tri=t;
        this.act=act;
    }
    void result(){
        if(tri.isTriggered()){
            act.execute();
        }
        else{
            System.out.println("trigger condition not met");
        }
    }
}


public class sh_autosys {
    public static void main(String[] args) {
        devices lig=new lightt();
        devices AC=new acc();
        trigger motion=new motion_trigger(true);
        trigger temp=new temp_trigger(45);
        trigger time=new time_trigger(20);
        action turnON=new turnOnAction(AC);
        action  turnOff=new turnOffAction(AC);
        Rule rule=new Rule(temp,turnON);
        rule.result();
    }
}

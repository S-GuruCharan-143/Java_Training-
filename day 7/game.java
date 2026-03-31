class warrior{
    void attack(){
        System.out.println("Attack with Sword");
    }


}
class archer{
    void attack(){
        System.out.println("Attack with Arrow");
    }
}
class mage{
    void attack(){
        System.out.println("Attack with Magic");
    }

}
public class game {
    public static void main(String[] args){
        warrior man=new warrior();
        archer sol=new archer();
        mage ma=new mage();
        man.attack();;
        sol.attack();
        ma.attack();

    }
}
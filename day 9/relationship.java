class battery{
    public void powersupply(){
        System.out.println("Still have 40% power");
    }
}

class remote{
    battery minbat; //has a relationship
    remote(){
        minbat=new battery();
    }
    public void changeChannel(){
        minbat.powersupply();
        System.out.println("channel changed");
    }
    public void changevol(){
        System.out.println("changed volumn");
    }
}

class Tv{
    remote tvrem;
    Tv(remote tvrem){
        this.tvrem=tvrem;
    }
    public void increasevol(){
        tvrem.changevol();
    }
}

public class relationship {
        public static void main(String[] args) {
            //remote tvrem=new remote();
            //tvrem.changeChannel();
            remote sonyrem=new remote();
            Tv sony=new Tv(sonyrem);
            sony.increasevol();
        }
}

import java.util.*;

class wave{
    public String waveForm(String str){
        StringBuilder str1=new StringBuilder();
        if(str.length()==0) return "null";
        else{
            for(int i=0;i<str.length();i+=2) str1.append(str.charAt(i));
            for(int i=1;i<str.length();i+=2) str1.append(str.charAt(i));
            }
            return str1.toString();
        }
}

public class waveform{
    public static void main(String[] args) {
        wave wa=new wave();
        String new1=wa.waveForm("VIRATHOKLI");
        System.out.println(new1);
    }   
}
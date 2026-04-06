import java.util.*;
public class ArrList {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1,2,2,3,4,3,5,6));
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)==list.get(j)){
                    list.remove(list.get(j));
                    j--;
                }
            }
        }
        System.out.println(list);
    }

}

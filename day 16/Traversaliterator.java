import java.util.ListIterator;
import java.util.Arrays;
import java.util.ArrayList;
public class Traversaliterator{
    public static void main(String[] agrs){
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(2,4,6,7,34,5));
         /*for(int i:list) //throws concurrent accessing error due to varying size of list due to remove operation
        {
            if(i==4)
            {
                list.remove(i);
            }
            System.out.println(i);
        }*/
        //Iterator<Integer> it=list.iterator();
        ListIterator<Integer> it=list.listIterator();
        while(it.hasNext()){
            int current=it.next();
            if(current==4){
                it.remove();
            }
        }
        while(it.hasPrevious()){
            int prev=it.previous();
            System.out.println(prev);
        }
        System.out.println(list);    
    }
}
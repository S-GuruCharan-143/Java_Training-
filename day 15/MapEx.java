import java.util.*;
public class MapEx{
    public static void main(String[] args){
        int[] array={1,2,3,3,4,5};
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<array.length;i++){
            map.put(i,array[i]);
        }
    }
}
import java.util.*;
public class ShortCharacters {
    public static List<Character> shortChar(String s){
        //1. frequency
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        //2. map stored in list
        List<Map.Entry<Character,Integer>> list=new ArrayList<>(map.entrySet());
        //3. sort
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
            //Collections.sort(list(a,b)->{})
            @Override
            public int compare(Map.Entry<Character,Integer> a,Map.Entry<Character,Integer> b){
                if(!a.getValue().equals(b.getValue())){
                 return b.getValue()-a.getValue();   
                }
                return a.getKey()-b.getKey();
            }
        });
        List<Character> res=new ArrayList<>();
        for(Map.Entry<Character,Integer> i:list){
            res.add(i.getKey());
        }
        return res;
    }
    public static void main(String[] args){
        String s="sttingsrraaarew";
        System.out.println(shortChar(s));
    }
}

import java.util.Scanner;
import java.util.TreeSet;

class closestTree{
    public int findClosest(int[] arr,int target){
        TreeSet<Integer> tree=new TreeSet<>();
        for(int i=0;i<arr.length;i++){
            tree.add(arr[i]);
        }
        Integer ceil=tree.higher(target);
        Integer floor=tree.lower(target);
        int ceildif=ceil-target;
        int floordif=target-floor;
        if(floordif<=ceildif) return floor;
        else return ceil; 
}
}

public class Closest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        closestTree clo=new closestTree();
        int target=sc.nextInt();
        System.out.println("res:"+clo.findClosest(arr,target));
    }
}

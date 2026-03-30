import java.util.*;
public class k_pattern {
    public static void solve(String s){
        int n = s.length();
        for(int i=0;i<n;i++){
            System.out.print(s.charAt(i));
            int spaces = Math.abs(n-1-2*i);
            for(int j=0;j<spaces;j++){
                System.out.print(" ");
            }
            if(i!=n-i) System.out.print(s.charAt(i));
        System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //int n = sc.nextInt();
        solve(s);
    }
}
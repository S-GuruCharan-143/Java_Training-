import java.util.*;
class Solution{
    public String ZigZag(String str,int n){
        if(n==1) return str;
        StringBuilder[] arr=new StringBuilder[n];
        boolean going_down=false;
        for(int i=0;i<n;i++){
            arr[i]=new StringBuilder();
        }
        int current=0;
        for(int i=0;i<str.length();i++){
            arr[current].append(str.charAt(i));
            if(current==0 || current==n-1){
                going_down=!going_down;
            } 
            if(going_down) current++;
            else current--;
        }
        StringBuilder res=new StringBuilder();
        for(StringBuilder s:arr){
            res.append(s);
        }
        return res.toString();
    }
}
public class leetcode_6{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String st="PAYPALISHIRING";
        int n=3;
        Solution sol=new Solution();
        System.out.print(sol.ZigZag(st, n)); 
    
    }
}
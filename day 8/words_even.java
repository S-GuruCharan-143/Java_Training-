class evenlength{
    public String words_even(String str){
        StringBuilder str1=new StringBuilder();
        boolean isword=false;
        char[] arr=str.toCharArray();
        int start=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=' ' && !isword){
                start=i;
                isword=true;
            }
            else if((arr[i]==' ' || i==str.length()-1) && isword ){
                int end=(arr[i]==' ')?i:i+1;
                if((end-start)%2==0){
                str1.append(arr,start,end-start);
                str1.append(" ");
                }
                isword=false;
            }
        }
        return str1.toString();

    }
}

public class words_even {
    public static void main(String[] args) {
        evenlength ev=new evenlength();
        String res=ev.words_even("this is a test code");
        System.out.println(res);
    }
}

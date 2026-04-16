import java.io.*;

public class Write {
    public static void main(String[] args){
        try{
            BufferedWriter w = new BufferedWriter(new FileWriter("test.txt"));
            w.write("Write using FileWriter1");
            w.newLine();
            w.write("Write using FileWriter2");
            w.newLine();
            w.write("Write using FileWriter3");
            w.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
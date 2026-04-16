import java.io.*;
public class FileRead {
    public static void main(String[] args){
        try{
            //FileReader fr = new FileReader("test.txt");
            BufferedReader fr = new BufferedReader(new FileReader("test.txt"));
            //int character;
            String line;
            while((line=fr.readLine())!=null){//-1 for FileReader
                System.out.println(line);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
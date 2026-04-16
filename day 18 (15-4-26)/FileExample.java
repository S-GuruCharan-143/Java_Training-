import java.io.*;

public class FileExample {
    public static void main(String[] args) throws IOException{
        File f = new File("test.txt");
        if(f.createNewFile()){
            System.out.println("File Created: " + f.getName());
        }
        else{
            System.out.println("Not able to create file");
        }
    }
}
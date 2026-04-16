import java.io.*;

public class DeleteExample {
    public static void main(String[] args) throws IOException{
        File f = new File("test.txt");
        if(f.delete()){
            System.out.println("File Deleted");
        }
        else{
            System.out.println("Not able to delete file");
        }
    }
}

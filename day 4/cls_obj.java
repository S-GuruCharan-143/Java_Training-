//class and objects
class Student{
    int rollNo;
    String name="abc";
    int marks=76;
    char c;
}
public class cls_obj{
    public static void main(String[] args) {
        Student s1=new Student();
        Student s2=new Student();
        System.out.println(s1.name);
    }
}
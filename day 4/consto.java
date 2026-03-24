//constructor-

class Student {
    int rollNo;
    String name = "abc";
    int marks = 76;
    char c;

    Student() {
        System.out.println("from constructor");
    }

    Student(int n, String name) {
        this.rollNo = n;   // FIXED
        this.name = name;
        System.out.println("name: " + this.name);
    }
}

public class consto {
    public static void main(String[] args) {
        Student s1 = new Student(43, "hello");
        Student s2=new Student();
        System.out.println(s1.rollNo);
        System.out.println(s1.name);
    }
}
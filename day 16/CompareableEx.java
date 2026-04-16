import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
class Student implements Comparable<Student>{
    String name;
    int mark;
    Student(String name,int mark){
        this.name=name;
        this.mark=mark;
    }
    public int compareTo(Student s){
    return this.mark-s.mark;
    }
    public void toString(Student s){
        System.out.println(s.name+"-"+s.mark);
    }

}
public class CompareableEx {
    public static void main(String[] args){
        List<Student> students=new ArrayList<>();
        students.add(new Student("A",70));
        students.add(new Student("B",55));
        students.add(new Student("C",65));
        students.add(new Student("D",85));
        Collections.sort(students);
        System.out.println(students);
    }    
}

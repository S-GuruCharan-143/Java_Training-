import java.util.Scanner;

public class area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("The area of the circle with radius " + radius + " is: " + area);
        sc.close();
    }
}

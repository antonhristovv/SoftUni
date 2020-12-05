import java.util.Scanner;

public class E03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        /*int courses = 0;

        if (peopleCount > capacity ){
            courses = peopleCount / capacity;
            peopleCount %= capacity;
        }
        if (peopleCount != 0) {
            courses ++;
        }*/
        int courses = (int) Math.ceil((double) peopleCount / capacity);
        System.out.println(courses);
    }
}

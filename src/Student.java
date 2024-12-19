import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {
    static int count = 1;
    public int id;
    public Classe refClasse;
    public int[] notes;

    ArrayList<Student> students = new ArrayList<Student>();
    // this should be an array
    // list of notes
    Scanner scr = new Scanner(System.in);

    Student (String firstName, String lastName, String email) {
        super( firstName, lastName, email);
        this.id = count;
        count++;
    }
    Student () {

    }
    void showInfo () {
        System.out.println("this student info");
    }

    void create ( boolean editing ) {
        while (editing) {
            System.out.println("Enter student's first name ");
            String firstName = scr.nextLine();
            if (firstName.equals("quite")) {
                System.out.println("stopped editing");
                editing = false;
            } else {
                System.out.println("Enter student's last name ");
                String lastName = scr.nextLine();
                if (lastName.equals("quite")) {
                    System.out.println("stopped editing");
                    editing = false;
                } else {
                    System.out.println("Enter student's email ");
                    String email = scr.nextLine();
                    if (email.equals("quite")) {
                        System.out.println("stopped editing");
                        editing = false;
                    } else {
                        // create a new student
                        Student student = new Student(firstName, lastName, email);
                        // add student to the list
                        students.add(student);
                    }
                }
            }
        }
    }
}

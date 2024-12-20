import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends Person {

    static int count = 1;
    public int id;
    public Classe refClasse;
    public int[] notes;

    static int subManuChoice;
    static boolean editing;

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

    void list () {
        if ( students.size() == 0) {
            System.out.println("No Students, Yet");
        } else {
            for ( Student student : students) {
                System.out.println("Fullname: " + student.firstName + " " + student.lastName );
                System.out.println("Email: " + student.email );
                System.out.println();
            }
        }
        System.out.println("==============================================");
        System.out.println("==============================================");
    }

    void show () {
        try {
            // show single student by id or by name
            System.out.println("search by by ID or by NAME");
            System.out.println("1. Search by ID");
            System.out.println("2. Search by NAME");
            int search = scr.nextInt();
            scr.nextLine();
            if ( search == 1) {
                // search by ID
                System.out.println("Enter student's ID");
                int id = scr.nextInt();
                scr.nextLine();
                for ( Student student : students ) {
                    if (student.id == id) {
                        System.out.println("Fullname: " + student.firstName + " " + student.lastName );
                        System.out.println("Email: " + student.email );
                        System.out.println();
                    }
                }
            }
            if ( search == 2) {
                // search by NAME
                System.out.println("Enter student's NAME");
                String name = scr.nextLine();
                for ( Student student : students ) {
                    if (student.firstName.equals( name ) || student.lastName.equals( name ) ) {
                        System.out.println("Fullname: " + student.firstName + " " + student.lastName );
                        System.out.println("Email: " + student.email );
                        System.out.println();
                    } else {
                        System.out.println("NO Student with this name !!");
                    }
                }
            }
        }
        catch ( InputMismatchException e ) {
            scr.nextLine();
            this.show();
        }
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

    void update ( int studenId) {
        // get student index
        Student student = null;

        for ( int i = 0; i < students.size(); i++ ) {
            if (students.get(i).id == studenId) {
                student = students.get(i);
                break;
            }
        }

        if ( student != null ) {
            System.out.println("Enter First Name :");
            String firstName = scr.nextLine();
            System.out.println("Enter Last Name :");
            String lastName = scr.nextLine();
            System.out.println("Enter Email :");
            String email = scr.nextLine();
            // update here
            student.firstName = firstName.length() == 0 ? student.firstName : firstName;
            student.lastName = lastName.length() == 0  ? student.lastName : lastName;
            student.email = email.length() == 0 ? student.email : email;
        } else {
            System.out.println("this ID does not Exists");
        }
        // TRY TO APPLY BINARY SEARCH
    }

    void delete ( int studentId ) {
        int studentIdx = 0;
        for ( int i = 0; i < students.size(); i++ ) {
            if (students.get(i).id == studentId) {
                studentIdx = students.indexOf(students.get(i));
                break;
            }
        }
        System.out.println("deleting student...");
        System.out.println("deleting the student with the index of " + studentIdx );
        students.remove(studentIdx);
        System.out.println("student deleted!!");
    }

    int subManu () {
        try {
            System.out.println("Please choose a number to select one CRUD operation (1,2,3,4,5)");
            System.out.println("0 => Quite Student Menu");
            System.out.println("1 => List all Students");
            System.out.println("2 => Show a single Student");
            System.out.println("3 => Add a Student");
            System.out.println("4 => Update a Student");
            System.out.println("5 => Delete a Student");
            subManuChoice = scr.nextInt();
            scr.nextLine();
            while (subManuChoice != 1 && subManuChoice != 2 && subManuChoice != 3 && subManuChoice != 4 && subManuChoice != 5 && subManuChoice != 0 ) {
                System.out.println("Unkown manu Type, please choose from the menu (1,2,3,4,5)");
                subManuChoice = scr.nextInt();
                scr.nextLine();
            }
            return subManuChoice;
        }
        catch ( InputMismatchException e ) {
            System.out.println("please enter valid number");
            scr.nextLine();
            return 6;
        }
    }

}

























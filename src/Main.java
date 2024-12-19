import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scr = new Scanner(System.in);

    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<Coach> coaches = new ArrayList<Coach>();
    static ArrayList<Classe> classes = new ArrayList<Classe>();
    static boolean appRunning = true;
    static char mainManu = 'h';
    static int subManuChoice;
    static boolean editing;


    public static void main(String[] args) {
        while (appRunning) {
            switch (mainManu){
                case 'h': // initial or home room
                    // show the main list manu
                    showHeader("home");
                    System.out.println("this is home");
                    mainManu = showHomeManu();
                    break;
                case 'c': // enter classe room
                    System.out.println("this is classe");
                    // show the list manu of a Classe:
                        // CRUD of Classe
                        // add a prof to the classe
                        // add a student or more to a classe
                        // remove a student form a classe
                        // change a prof of a classe
                        // show a list of students belong to this classe
                    break;
                case 's': // enter student room
                    studentFunc();
                    // show the list of CRUD students
                    break;
                case 'f': // enter coach room
                    // CRUD of Coach
                    System.out.println("this coach");
                    break;
                case 'q':
                    System.out.println("Good Bye");
                    appRunning = false;
                    break;

            }
        }
    }

    //validate Character it should be one of these (H,C,S,F)
    // show the global manu of the application
    static char showHomeManu () {
        System.out.println("Please choose one of the characters (h,c,s,f)");
        System.out.println("c => Classe");
        System.out.println("s => Student");
        System.out.println("f => Coach");
        System.out.println("h => Home");
        String manuChar =  scr.nextLine();
        // check if the user enters more than 2 chars
        if ( manuChar.length() > 1) {
            System.out.println("you entered more that one character, allowed characters (h,c,s,f)");
            manuChar =  scr.nextLine();
        }
        // force user to enter one of these chars (h,s,f,c)
        while (manuChar.charAt(0) != 'h' && manuChar.charAt(0) != 'c' && manuChar.charAt(0) != 's' && manuChar.charAt(0) != 'f' && manuChar.charAt(0) != 'q') {
            System.out.println("invalid Character please enter one of these (h,c,f,s,q)");
            manuChar =  scr.nextLine();
        }
        return manuChar.charAt(0);
    }

    static void showHeader ( String heading ) {
        System.out.println("******************************************");
        System.out.println("******* " + heading.toUpperCase() + " ******");
        System.out.println("******************************************");
    }

    static int subManu () {

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

    // CRUD Functions
    // Student
    static public void addStudent () {
        editing = true;
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

    static void showStudents () {
        showHeader("All Students");
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

    static void showSingleStudent () {
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
            showSingleStudent();
        }
    }

    // update a student
    static void updateStudent( int id ) {
        // get student index
        Student student = null;

        for ( int i = 0; i < students.size(); i++ ) {
            if (students.get(i).id == id) {
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

    // delete student
    static void deleteStudent ( int id ) {
        int studentID = 0;
        for ( int i = 0; i < students.size(); i++ ) {
            if (students.get(i).id == id) {
                studentID = students.indexOf(students.get(i));
                break;
            }
        }
        System.out.println("deleting student...");
        System.out.println("deleting the student with the index of " + studentID );
        students.remove(studentID);
        System.out.println("student deleted!!");
    }

    // Create functionalities for student
    static void studentFunc () {
        int menu = subManu();
        boolean subManuRunning = true;
        int id;

        Student student = new Student();

        while (subManuRunning) {
            switch (menu) {
                case 0:
                    System.out.println("Out of Student Menu");
                    subManuRunning = false;
                    mainManu = showHomeManu();
                    break;
                case 1:
                    showStudents();
                    menu = subManu();
                    break;
                case 2:
                    showSingleStudent();
                    menu = subManu();
                    break;
                case 3:
                    editing = true;
                    student.create( editing );
                    menu = subManu();
                    break;
                case 4:
                    System.out.println("Please enter Student's ID ");
                    id = scr.nextInt();
                    scr.nextLine();
                    updateStudent( id );
                    menu = subManu();
                    break;
                case 5:
                    System.out.println("please enter Student's ID");
                    id = scr.nextInt();
                    scr.nextLine();
                    deleteStudent( id );
                    menu = subManu();
                    break;
                case 6:
                    menu = subManu();
                    break;
            }
        }

    }
}

// VALIDATION FUNCTIONS
// validate Charachter it should be one of these (H,C,S,F)
// validate ints
// validate doubles
// validate email
// validate if a classe has a coach

// create the size of a class
// add a student to classe
// add a prof to a classe

// CRUD Functions (Classe, Student, Coach)


















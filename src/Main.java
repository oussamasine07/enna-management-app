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

    // create object instances
    static Student student = new Student();


    public static void main(String[] args) {
        Student student = new Student();
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
                    coachFunc();
                    break;
                case 'q':
                    System.out.println("Good Bye");
                    appRunning = false;
                    break;

            }
        }
    }

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

    // Create functionalities for student
    static void studentFunc () {
        int menu = student.subManu();
        boolean subManuRunning = true;
        int id;

        while (subManuRunning) {
            switch (menu) {
                case 0:
                    System.out.println("Out of Student Menu");
                    subManuRunning = false;
                    mainManu = showHomeManu();
                    break;
                case 1:
                    student.list();
                    menu = student.subManu();
                    break;
                case 2:
                    student.show();
                    menu = student.subManu();
                    break;
                case 3:
                    editing = true;
                    student.create( editing );
                    menu = student.subManu();
                    break;
                case 4:
                    System.out.println("Please enter Student's ID ");
                    id = scr.nextInt();
                    scr.nextLine();
                    student.update( id );
                    menu = student.subManu();
                    break;
                case 5:
                    System.out.println("please enter Student's ID");
                    id = scr.nextInt();
                    scr.nextLine();
                    student.delete( id );
                    menu = student.subManu();
                    break;
                case 6:
                    menu = student.subManu();
                    break;
            }
        }

    }

    // create functionality for Coach
    static void coachFunc () {
        Coach coach = new Coach();
        int menu = coach.subManu();
        boolean subManuRunning = true;
        int id;

        while (subManuRunning) {
            switch (menu) {
                case 0:
                    System.out.println("Out of Coach Menu");
                    subManuRunning = false;
                    mainManu = showHomeManu();
                    break;
                case 1:
                    coach.list();
                    menu = coach.subManu();
                    break;
                case 2:
                    coach.show();
                    menu = coach.subManu();
                    break;
                case 3:
                    editing = true;
                    //coach.create( editing );
                    menu = coach.subManu();
                    break;
                case 4:
                    System.out.println("Please enter Coach's ID ");
                    id = scr.nextInt();
                    scr.nextLine();
                    //coach.update( id );
                    menu = coach.subManu();
                    break;
                case 5:
                    System.out.println("please enter Coach's ID");
                    id = scr.nextInt();
                    scr.nextLine();
                    //coach.delete( id );
                    menu = coach.subManu();
                    break;
                case 6:
                    menu = coach.subManu();
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


















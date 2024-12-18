import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Coach> coaches = new ArrayList<Coach>();
        ArrayList<Classe> classes = new ArrayList<Classe>();


        boolean appRunning = true;
        char room = 'h';

        while (appRunning) {
            switch (room){
                case 'h': // initial or home room
                    // show the main list manu
                    System.out.println("this is home");
                    room = showHomeManu();
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
                    System.out.println("this is student");
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
        if (manuChar.charAt(0) != 'h' && manuChar.charAt(0) != 'c' && manuChar.charAt(0) != 's' && manuChar.charAt(0) != 'f' && manuChar.charAt(0) != 'q') {
            System.out.println("invalid Character please enter one of these (h,c,f,s,q)");
            manuChar =  scr.nextLine();
        }
        return manuChar.charAt(0);
    }

    // CRUD Functions
    // Student
    static public void addStudent () {
        System.out.println("Enter student's first name ");
        String firstName = scr.nextLine();
        System.out.println("Enter student's last name ");
        String lastName = scr.nextLine();
        System.out.println("Enter student's email ");
        String email = scr.nextLine();

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


















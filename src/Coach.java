import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Coach extends Person {
    private static int count = 1;
    private int id;
    private String refClasse;
    private double salary;
    private String specialty;

    ArrayList<Coach> coaches = new ArrayList<Coach>();

    static int subManuChoice;
    static boolean editing;

    Scanner scr = new Scanner(System.in);

    Coach (String firstName, String lastName, String email, double salary, String specialty ) {
        super(firstName, lastName, email);
        this.id = count;
        //this.refClasse = refClasse;
        this.salary = salary;
        this.specialty = specialty;
        count++;
    }

    Coach () {

    }

    // getters
    public double getSalary () {
        return this.salary;
    }
    public String getSpecialty () {
        return this.specialty;
    }

    // setters
    public void setSalary ( double salary ) {
        this.salary = salary;
    }
    public void setSpecialty ( String specialty) {
        this.specialty = specialty;
    }

    // CRUD functionality
    void list () {
        if ( coaches.size() == 0) {
            System.out.println("No Coaches, Yet");
        } else {
            for ( Coach coach : coaches) {
                System.out.println("Fullname: " + coach.getFirstName() + " " + coach.getLastName() );
                System.out.println("Email: " + coach.getEmail() );
                System.out.println("Spechialty: " + coach.getSpecialty() );
                System.out.println("Salery: " + coach.getSalary() );
                System.out.println();
            }
        }
        System.out.println("==============================================");
        System.out.println("==============================================");
    }

    void show () {
        try {
            // show single student by id or by name
            System.out.println("search by Coach ID or by NAME");
            System.out.println("1. Search by ID");
            System.out.println("2. Search by NAME");
            int search = scr.nextInt();
            scr.nextLine();

            Coach foundCoach = null;

            if ( search == 1) {
                // search by ID
                System.out.println("Enter Coach's ID");
                int id = scr.nextInt();
                scr.nextLine();
                for ( Coach coach : coaches ) {
                    if (coach.id == id) {
                        foundCoach = coach;
                        break;
                    }
                }
            }

            if ( search == 2) {
                // search by NAME
                System.out.println("Enter Coach's NAME");
                String name = scr.nextLine();
                for ( Coach coach : coaches ) {
                    if (coach.getFirstName().equals( name ) || coach.getLastName().equals( name ) ) {
                        foundCoach = coach;
                        break;
                    }
                }
            }

            if ( foundCoach != null) {
                System.out.println("Fullname: " + foundCoach.getFirstName() + " " + foundCoach.getLastName() );
                System.out.println("Email: " + foundCoach.getEmail() );
                System.out.println("Spechialty: " + foundCoach.getSpecialty() );
                System.out.println("Salery: " + foundCoach.getSalary() );
                System.out.println();
            } else {
                System.out.println("un found Coach");
            }
        }
        catch ( InputMismatchException e ) {
            scr.nextLine();
            this.show();
        }
    }

    void create ( boolean editing ) {
        double salaryChecking = -1;
        while (editing) {
            System.out.println("Enter coach's first name ");
            String firstName = scr.nextLine();
            if (firstName.equals("quite")) {
                System.out.println("stopped editing");
                editing = false;
            } else {
                System.out.println("Enter coach's last name ");
                String lastName = scr.nextLine();
                if (lastName.equals("quite")) {
                    System.out.println("stopped editing");
                    editing = false;
                } else {
                    System.out.println("Enter email's email ");
                    String email = scr.nextLine();
                    if (email.equals("quite")) {
                        System.out.println("stopped editing");
                        editing = false;
                    } else {
                        System.out.println("Enter coach's specialty ");
                        String spechialty = scr.nextLine();
                        if ( spechialty.equals("quite") ) {
                            System.out.println("stopped editing");
                            editing = false;
                        } else {
                            while ( salaryChecking <= 0 ) {
                                try{
                                    System.out.println("Enter coach's salary ");
                                    double salary = scr.nextDouble();
                                    scr.nextLine();
                                    if ( salary == 0 ) {
                                        System.out.println("stopped editing");
                                        editing = false;
                                        break;
                                    } else {
                                        // create a new coach
                                        Coach coach = new Coach(firstName, lastName, email, salary, spechialty);
                                        // add coach to the list
                                        coaches.add(coach);
                                        break;
                                    }
                                }
                                catch ( InputMismatchException e ) {
                                    System.out.println("please enter a valid double");
                                    scr.nextLine();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

//    void update ( int studenId) {
//        // get student index
//        Student student = null;
//
//        for ( int i = 0; i < students.size(); i++ ) {
//            if (students.get(i).id == studenId) {
//                student = students.get(i);
//                break;
//            }
//        }
//
//        if ( student != null ) {
//            System.out.println("Enter First Name :");
//            String firstName = scr.nextLine();
//            System.out.println("Enter Last Name :");
//            String lastName = scr.nextLine();
//            System.out.println("Enter Email :");
//            String email = scr.nextLine();
//            // update here
//            student.setFirstName( firstName.length() == 0 ? student.getFirstName() : firstName );
//            student.setLastName( lastName.length() == 0  ? student.getFirstName() : lastName );
//            student.setEmail(email.length() == 0 ? student.getEmail() : email);
//
//        } else {
//            System.out.println("this ID does not Exists");
//        }
//        // TRY TO APPLY BINARY SEARCH
//    }
//
//    void delete ( int studentId ) {
//        int studentIdx = 0;
//        for ( int i = 0; i < students.size(); i++ ) {
//            if (students.get(i).id == studentId) {
//                studentIdx = students.indexOf(students.get(i));
//                break;
//            }
//        }
//        System.out.println("deleting student...");
//        System.out.println("deleting the student with the index of " + studentIdx );
//        students.remove(studentIdx);
//        System.out.println("student deleted!!");
//    }

    // Show sub menu for student class
    int subManu () {
        try {
            System.out.println("Please choose a number to select one CRUD operation (1,2,3,4,5)");
            System.out.println("0 => Quite Coach Menu");
            System.out.println("1 => List all Coaches");
            System.out.println("2 => Show a single Coach");
            System.out.println("3 => Add a Coach");
            System.out.println("4 => Update a Coach");
            System.out.println("5 => Delete a Coach");
            System.out.println("6 => Assign Coach to a Classe");
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

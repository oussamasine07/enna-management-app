import java.util.InputMismatchException;
import java.util.Scanner;

public class Coach extends Person {
    private static int count = 1;
    private int id;
    private String refClasse;
    private double salary;
    private String specialty;

    static int subManuChoice;
    static boolean editing;

    Scanner scr = new Scanner(System.in);

    Coach (String firstName, String lastName, String email, String refClasse, double salary, String specialty ) {
        super(firstName, lastName, email);
        this.id = count;
        this.refClasse = refClasse;
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

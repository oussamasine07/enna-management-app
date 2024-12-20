public class Coach extends Person {
    private static int count = 1;
    private int id;
    private String refClasse;
    private double salary;
    private String specialty;

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


}

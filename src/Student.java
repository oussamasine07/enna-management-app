public class Student extends Person {
    static int count = 1;
    public int id;
    public Classe refClasse;
    public int[] notes;
    // this should be an array
    // list of notes
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

    void create () {

    }
}

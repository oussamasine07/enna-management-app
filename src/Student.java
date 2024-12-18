public class Student extends Person {
    private int id = 1;
    private Classe refClasse;
    // this should be an array
    // list of notes
    Student (String firstName, String lastName, String email) {
        super( firstName, lastName, email);
    }
    void showInfo () {
        System.out.println("this student info");
    }
}

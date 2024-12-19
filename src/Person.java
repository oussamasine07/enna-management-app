public abstract class Person {
    public String firstName;
    public String lastName;
    public String email;

    Person ( String firstName, String lastName, String email ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    Person(){

    }
    abstract void showInfo ();

}

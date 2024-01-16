package people;

public abstract class Person extends Human{
    protected String name;
    public Person(String name, String post) {
        super(post);
        this.name = name;
    }
    abstract void getThought (int numberMassiv);
    abstract void addThought(String message);
}

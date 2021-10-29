

public class Employee implements Measurable {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name) {
        this(name, 0);
    }

    public Employee() {
        this("Anonymous empoyee", 0);
    }

    public String getName() {
        return this.name;
    }
    @Override
    public double getMeasure() {
        return salary;
    }
    
}

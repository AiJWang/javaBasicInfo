package StreamAPIStudy;

public class Employee {
    public String name;
    public Integer age;
    public double salary;
    public Status status;
    public enum Status{
        FREE,
        BUSY,
        HOME;
    }
    public Employee(){

    }
    Employee( String name,Integer age, double salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    public Employee(String name, Integer age, double salary, Status status){
        this.name=name;
        this.age=age;
        this.salary=salary;
        this.status=status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}

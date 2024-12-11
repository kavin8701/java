class Employee{
    private String name;
    private String jobTitle;
    private double salary;

    public Employee(String name,String jobTitle,double salary){
        this.name=name;
        this.jobTitle=jobTitle;
        this.salary=salary;
    }

    public String getName(){
        return name;
    }
    public void setName(){
        this.name=name;
    }

    public String getjobTitle(){
        return jobTitle;
    }
    public void setjobTitle(){
        this.jobTitle=jobTitle;
    }

    public double getSalary(){
        return salary;
    }
    public void setSalary(){
        this.salary=salary;
    }

    public void increaseSalary(double percentage){
        if(percentage>0){
            salary += salary * (percentage/100);
        }
        else{
            System.out.println("No Increment");
        }
    }

    public void updateSalary(double newSalary){
        if(newSalary>=0){
            salary=newSalary;
        }
        else{
            System.out.println("Same Salary");
        }
    }

    public void display(){
        System.out.println("Employee Name:" +name);
        System.out.println("Job Title:" +jobTitle);
        System.out.println("Salary:" +salary);
    }

}
public class Demo{
public static void main(String a[]){
    Employee Emp = new Employee("Kavin", "PAT", 25000);
    Emp.display();
    Emp.increaseSalary(10);
    System.out.println("\nAfter increment:");
    Emp.display();
    Emp.updateSalary(80000);
    System.out.println("\nAfter direct salary update:");
    Emp.display();

}
}

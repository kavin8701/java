class Human{
private int age;
private String name;

public Human()
{
    System.out.println("in constructor");
    name = "Kavin";
    age = 23;
}

public Human(int a,String n)
{
    System.out.println("in constructor");
    name = n;
    age = a;
}
public void setAge(int age){
   this.age=age;
}
public int getAge(){
    return age;
}
public void setName(String name){
    this.name=name;
}
public String getName(){
    return name;
}
}


public class Constructor {
public static void main(String args[]){
    Human obj=new Human();
    Human obj1=new Human(25,"kav");
    System.out.println(obj.getName() +" : "+ obj.getAge());
    System.out.println(obj1.getName() +" : "+ obj1.getAge());
    obj.setAge(23);
    obj.setName("kavin");

    //System.out.println(obj.getName() +" : "+ obj.getAge());
}
}
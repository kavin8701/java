class A{

    public A()
    {
        System.out.println("Object created");
    }
    public void show()
    {
        System.out.println("in a show");
    }

}
public class Anonymous{
    public static void main(String a[])
    {
        new A();
        new A().show();
    }
}
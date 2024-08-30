
public class Demo {
    public static void main(String a[])
    {
        VeryAdvCalc obj = new VeryAdvCalc();
        int r1=obj.add(5,6);
        int r2=obj.sub(10,6);
        int r3=obj.multi(9,4);
        int r4=obj.div(8,2);
        double r5=obj.power(8,2);

        System.out.println(r1 + " "+ r2 + " " + r3 + " " + r4 + " " + r5);
    }

}

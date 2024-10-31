import java.util.*;
class Add extends Thread
{
    int a;
    int b;
    Add(int l,int n)
    {
        a=l;
        b=n;
    }
    public void run()
    {
        Thread t=Thread.currentThread();
        if(t.getName()=="Add")
        {
            int sum=a+b;
            System.out.println(sum);
        }
        else
        {
            int difference=a-b;
            System.out.println(difference);
        }
    }
}
public class MultiThreading
{
    public static void main(String[]args)throws Exception
    {
        Scanner scan =new Scanner(System.in);
        System.out.println("enter two numbers");
        int a=scan.nextInt();
        int b=scan.nextInt();
        Add t1=new Add(a,b);
        t1.setName("Add");
        t1.start();
        t1.join();
        Add t2=new Add(a,b);
        t2.setName("SUB");
        t2.start();
        
    }
}

//Method overloading concept 
import java.util.Scanner;
class Container
{
    Scanner scan =new Scanner(System.in);
    public void area()
    {
        System.out.println("enter the radius of the circle");
        int r=scan.nextInt();
        double f=3.14*r*r;
        System.out.println("The area of the circle is :"+f);
    }
    public void area(int l)
    {
        System.out.println("enter the breadth of the rectangle");
        int b=scan.nextInt();
        double r=l*b;
        System.out.println("The area of the rectangle is :"+r);
    }    
    public void area(int h,int w)
    {
        double t=0.5*h*w;
        System.out.println("The area of the triangle is :"+t);
    }
}
public class Area
{
    public static void main(String[]args)
    {
        Scanner scanner=new Scanner(System.in);
        Container container=new Container();// create the object for container class to call that class easily
        System.out.println("Choose the shape from the below menu to find the area");
        System.out.println("1.circle 2.rectangle 3.triangle");
        int a=scanner.nextInt();
        switch(a)
        {
            case 1:
                {
                    container.area();
                    
                    break;
                }
            case 2:
                {
                    System.out.println("enter the length of the rectangle");
                    int length=scanner.nextInt();
                   container.area( length);//the paramneter you passed should have different name 
                    break;
                }
            case 3:
                {
                    System.out.println("enter the length of the triangel");
                    int heigth=scanner.nextInt();
                    System.out.println("enter the width of the triangle");
                    int width=scanner.nextInt();
                    container.area( heigth, width);
                    break;
                }
            default:
            {
                System.out.println("Invalid operation");
            }
        }
    }
}

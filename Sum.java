import java.util.*;
public class Sum
{
    public static void main(String[]args)
    {
        Scanner scan =new Scanner(System.in);
        System.out.println("enter the line seprator");
        String x=scan.next();
        StringTokenizer a=new StringTokenizer(x,",");
        int n,sum=0;
        while(a.hasMoreTokens())
        {
            n=Integer.parseInt(a.nextToken());
            System.out.println(n);
            sum=sum+n;
        }
        System.out.println(sum);
        
        
    }
}

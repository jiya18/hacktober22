import java.util.*;
public class prime{
    public static void main(String args[])
    {
        int i,flag=-1;
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number");
        n=sc.nextInt();
        if(n==0 ||n==1)
            System.out.println("the number is neither prime nor composite");
        else
            for(i=2;i<n-1;i++)
            {   if(n%i==0)
                 {
                    flag=1;
                    System.out.println("the number is not a prime number");
                    break;
                 }
            
                else
                    flag=0;
            }
        if(flag==0)
             System.out.println("the number is a prime number");
        

    }
}
import java.util.Scanner;
public class Test{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long  i,j;
        long  n,l,r;
        //long x=1000000;
        int[] a=new int[1000001];
        for(i=1;i<=1000000;i++)
        {
            a[(int) i]=-1;
        }
        n=sc.nextLong();
        for(i=1;i<=n;i++)
        {
            l=sc.nextLong();
            r=sc.nextLong();
            if(a[(int) l]!=0||a[(int) r]!=0)
            {
                for(j=l;j<=r;j++)
                {
                    a[(int) j]=0;
                }
            }
        }
        long sum=0;
        for(i=1;i<=1000000;i++)
        {
            if(a[(int) i]==-1)
                sum=sum+i;
        }
        System.out.println(sum);

    }


}

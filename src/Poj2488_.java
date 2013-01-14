import java.util.*;
 public class Poj2488_ {
  
  int flag[][];
  int px[];
  int py[];
  static int dir[][] ={{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};//这里是有顺序的，题目要求是最小字典序
  int p,q;
  boolean ok;

   public Poj2488_(int p,int q){
     this.p=p;
     this.q=q;
     ok=false;
     flag=new int[p+1][q+1];
     px=new int[p*q+1];
     py=new int[p*q+1];
     flag[1][1]=1;
   }
  
  public void display(){
     for(int i=1;i<=p*q;i++)
        System.out.printf("%c%d",px[i]+'A'-1,py[i]);//这里很好，直接转换成字符
        System.out.printf("\n");
  }
  
  
 public void dfs(int x,int y,int length)
{
    px[length] = x;py[length] = y;//用来存放路径
    if(length == q*p)
    {
        ok = true;
        return ;
    }
    for(int i=0;i< 8;i++)
    {
       
        int ni = x + dir[i][0];
        int nj = y + dir[i][1];
        if(ni >=1 && ni<=p && nj >= 1 && nj <=q )
          if(flag[ni][nj] == 0 && !ok)
        {
            flag[ni][nj] = 1;
            dfs(ni,nj,length+1);
            flag[ni][nj] = 0;//这里就是回溯，很重要！！！
        }
    }
}

public static void main(String args[]){
    int n,num=0;
    Scanner sc=new Scanner(System.in);
    int p1=0;
    int q1=0;
    n=sc.nextInt();
        while((n--)!=0)
        {
            num++;
        
            System.out.println("Scenario #"+num+":");
            q1=sc.nextInt();
            p1=sc.nextInt();
            Poj2488_ m=new Poj2488_(p1,q1);
            m.dfs(1,1,1);
            if(m.ok)
              m.display();
            else
                System.out.println("impossible");

            if(n!=0) System.out.println();
        }
    }
   
}

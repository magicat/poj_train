import java.util.Scanner;

public  class Poj1753{
   static  int steps=Integer.MAX_VALUE; 
 //(x,y)����������������ĵ㼰����������������
      static  int[] dx={0,0,0,1,-1}; 
      static  int[] dy={0,1,-1,0,0};  

     /* 
      * ��ÿһ�е�״̬������״̬����2���Ʊ�ʾ���ĸ�2�������ų�һ�У��������״̬��
      * 1010
      * 0000
      * 1101
      * 1001
      *��ͼ��״̬��ʾΪ��1010000011011001
      * @param x�������(ע�⣺����ϵ����Ϊ(0,0)����Ϊ��3,3����
      * @param y�������
      * @param source(����״̬�������1010000011011001��
      * @return �ı�ȷ��λ�õ�״̬����1���0����0���1 
      * */  

   public static int flip(int x, int y, int source){ 
          if(x >= 0 && x < 4 && y >= 0 && y < 4)  
            source ^= 1 << (x * 4 + y);
          return source; 
     }  


     /* 
      * @param current��ǰ��
      * @param num �غ���
      * @param source ԭ���ݣ����磺1010000011011001
      * @param flag ��־ �������Դ��ǰλ��״̬��Ϊflag���򷭶�
      * */

	public static void dfs(int current,int num,int source,int flag){
          //������һ���Ѿ�����
          if(current==4){
              if(source==0xffff||source==0){
                  //�Ѿ����������
                  steps=num< steps?num:steps;
              } 
             return; 
         }   

       //�ѵ�ǰ�ж�����ͬ����ɫ 
         int x,y; 
         for (int i = current-1,j=0; j < 4; j++) {//ÿ�����ĸ��������߲�����������Ҫ�Ĵ� 
             if( (((source& (1 << (i*4+j) ))>>(i*4+j)) ^ flag)==1 ){
                  /*source& (1 << (i*4+j) )>>(i*4+j) :��source�е�(i,j)��״̬ȡ����*/ 
                for (int k = 0; k <5; k++) {//��ǰ���������Ҷ��÷��� 
                     x=current+dx[k]; 
                     y=j+dy[k];
                      source=flip(x, y, source); 
                 } 
                 num++; 
             }  
        }  

           //����һ�� 
         dfs(current+1, num, source, flag); 
      }  
 

     /*  ��һ�й���16�ַ�������������������������������������������������������������������������
      * */ 
     public static int solve(int source){  
         for (int i = 0; i < 16; i++) {  
             int num=0,temp=source,x,y;  
             for (int j = 0; j < 4; j++) { // ���ѭ���Ƿ���һ��
                 if((i&(1 << j))>0){  
                     for (int k = 0; k < 5; k++) {//��ǰ���������Ҷ��÷���  
                         x=0+dx[k];  
                         y=j+dy[k];  
                         temp=flip(x, y, temp);  
                     }  
                     num++;  
                 }  
             }  
  
             dfs(1, num, temp, 0);  //ȫ�����ɰ�ɫ
 
            dfs(1, num, temp, 1);  //ȫ�����ɺ�ɫ
         }  
         return steps==Integer.MAX_VALUE?-1:steps;  
     }  

 public static void main(String[] args) {  
         Scanner scanner=new Scanner(System.in);  
         int source=0;  
         String string="";  
         for (int i = 0; i < 4; i++) {  
             string+=scanner.nextLine().trim();  
         }  

        // System.out.println(string);
         for (int i = 0; i < string.length(); i++) {  
                 source=(source << 1)+(string.substring(i, i+1).equals("b")?1:0);  
         }  
       //  System.out.println(Integer.toBinaryString(source));
         if(solve(source)!=-1){  
             System.out.println(steps);  
         }else {  
             System.out.println("Impossible");  
  
         }  
     }  
 }  
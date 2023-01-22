import java.util.*;
public class minesweeper{
   public static void fillmines(int[][]A){
      int num=0;
      int raw,col;
      while(num<4){
         raw=(int)(Math.random()*5);
         col=(int)(Math.random()*5);
         num++;
         A[raw][col]=9;
         A[raw][col]=9;
      }
   }
   public static void calculateclues(int[][]A){
      int raw,col;
      int count=0;
      int n;
      while(count<200){
         raw=(int)(Math.random()*5);
         col=(int)(Math.random()*5);
         while(A[raw][col]!=0){
             raw=(int)(Math.random()*5);
             col=(int)(Math.random()*5);
         }
         n=0;
         count++;
         if(raw!=0&&col!=0&&raw!=4&&col!=4){
            if(A[raw-1][col-1]==9){
               n++;
            }
            if(A[raw-1][col]==9){
               n++;
            }
            if(A[raw-1][col+1]==9){
               n++;
            }
            if(A[raw][col-1]==9){
               n++;
            }
            if(A[raw][col+1]==9){
               n++;   
            }
            if(A[raw+1][col-1]==9){
               n++;
            }
            if(A[raw+1][col]==9){
               n++;
            }
            if(A[raw+1][col+1]==9){
            n++;
            }
            A[raw][col]=n;
         }
         if((raw==1&&col==0)||(raw==2&&col==0)||(raw==3&&col==0)){
            if(A[raw-1][col]==9){
               n++;
            }
            if(A[raw-1][col+1]==9){
            n++;
            }
            if(A[raw][col+1]==9){
            n++;
            }
            if(A[raw+1][col]==9){
            n++;
            }
            if(A[raw+1][col+1]==9){
            n++;
            }
            A[raw][col]=n;
         }
         if((raw==4&&col==1)||(raw==4&&col==2)||(raw==4&&col==3)){
            if(A[raw-1][col-1]==9){
            n++;
            }
            if(A[raw-1][col]==9){
            n++;
            }
            if(A[raw-1][col+1]==9){
            n++;
            }
            if(A[raw][col-1]==9){
            n++;
            }
            if(A[raw][col+1]==9){
            n++;
            }
            A[raw][col]=n;
         }
         if((raw==0&&col==1)||(raw==0&&col==2)||(raw==0&&col==3)){
            if(A[raw][col-1]==9){
            n++;
            }
            if(A[raw][col+1]==9){
            n++;
            }
            if(A[raw+1][col-1]==9){
            n++;
            }
            if(A[raw+1][col]==9){
            n++;
            }
            if(A[raw+1][col+1]==9){
            n++;
            }
            A[raw][col]=n;
         }
         if((raw==1&&col==4)||(raw==2&&col==4)||(raw==3&&col==4)){
            if(A[raw-1][col-1]==9){
               n++;
            }
            if(A[raw-1][col]==9){
            n++;
            }
            if(A[raw][col-1]==9){
            n++;
            }
            if(A[raw+1][col-1]==9){
            n++;
            }
            if(A[raw+1][col]==9){
            n++;
            }
            A[raw][col]=n;
         }
         if(raw==0&&col==0){
            if(A[raw][col+1]==9){
            n++;
            }
            if(A[raw+1][col]==9){
            n++;
            }
            if(A[raw+1][col+1]==9){
            n++;
            }
            A[raw][col]=n;
         }
         if(raw==4&&col==0){
            if(A[raw-1][col]==9){
            n++;
            }
            if(A[raw-1][col+1]==9){
            n++;
            }
            if(A[raw][col+1]==9){
            n++;
            }
            A[raw][col]=n;
         }
         if(raw==0&&col==4){
            if(A[raw][col-1]==9){
            n++;
            }
            if(A[raw+1][col-1]==9){
            n++;
            }
            if(A[raw+1][col]==9){
            n++;
            }
            A[raw][col]=n;
         }
         if(raw==4&&col==4){
            if(A[raw-1][col-1]==9){
            n++;
            }
            if(A[raw-1][col]==9){
            n++;
            }
            if(A[raw][col-1]==9){
            n++;
            }
            A[raw][col]=n;
         }
       }
   }
   public static void marktile(String[][]B,int[][]A){
      int raw,col;
       for(raw=0;raw<5;raw++){
          for(col=0;col<5;col++){
             B[raw][col]=" ";
          }
      }
      for(raw=0;raw<5;raw++){
          for(col=0;col<5;col++){
             System.out.print("["+B[raw][col]+"]"+" ");
          }
          System.out.println();
      }
      int count=0;
      while(true){
         Scanner input=new Scanner(System.in);
         System.out.print("if you want to flag press 9 or  any number to open a tile: ");
         int n=input.nextInt();
         System.out.print("enter row index: ");
         raw=input.nextInt();
         System.out.print("enter colomn index: ");
         col=input.nextInt();
         raw--;
         col--;
         if(raw>4||col>4){
           System.out.print("enter row index: ");
           raw=input.nextInt();
           System.out.print("enter colomn index: ");
           col=input.nextInt();
           raw--;
           col--;
         }
         if(B[raw][col]!=" "){
           System.out.print("enter row index: ");
           raw=input.nextInt();
           System.out.print("enter colomn index: ");
           col=input.nextInt();
           raw--;
           col--;
         }
         if(n==9){
            B[raw][col]="#";
            
            for(raw=0;raw<5;raw++){
               for(col=0;col<5;col++){
                System.out.print("["+B[raw][col]+"]"+" ");
               }
               System.out.println();
            }
            continue;
         }
         B[raw][col]=Integer.toString(A[raw][col]);
         if(A[raw][col]==9){
            System.out.print("sorry you lost you have opened a bomb try again next time");
            break;
         }

         for(raw=0;raw<5;raw++){
            for(col=0;col<5;col++){
               System.out.print("["+B[raw][col]+"]"+" ");
               }
               System.out.println();
         }
         count++;
         if(count==21){
            System.out.print("wow you won");
            break;
         }
      }
   }
   public static void main(String[]args){
      int[][]A=new int[5][5];
      String[][]B=new String[5][5];
      fillmines(A);
      calculateclues(A);
      marktile(B,A);
  }
}
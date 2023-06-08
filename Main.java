// Tic Tac Toe
//X  Gaurav
//O  Sagar
import java.util.*;
public class Main
{
	static Scanner input=new Scanner(System.in);
	static char[][] board=new char[3][3];
	static int total=3*3;
   public static void main(String[] args)
   {
	   for(int i=0;i<3;i++)
	   {
		   for(int j=0;j<3;j++)
			   board[i][j]='-';
	   }
        Player[] player=new Player[2];
		System.out.println("Enter the Player Name and Piece\n");
	    for(int i=0;i<2;i++)
		{
		 System.out.print("Enter the piece : ");
		 char piece=input.next().charAt(0);
		 System.out.print("Enter the Name : ");
		 String name =input.next();
		 player[i]=new Player(name ,piece);
		 System.out.println();
	   }
	   
	   while(true)
	   {
		   System.out.print("Do u want to continue (y/n) : ");
		   String command=input.next().toLowerCase();
		   System.out.println();
		   switch(command)
		   {
		    case "y": 
			     for(int i=0;i<2;i++)
				   {
					   
					   System.out.println("(x,y) :");
					   int x=input.nextInt();
					   int y=input.nextInt();
					   if(board[x-1][y-1]=='-')
					   {
						   board[x-1][y-1]=player[i].piece;
							--total;
						   if(check(player[i].piece,x-1,y-1))
						   {
							  
							   display();
							   System.out.println(player[i].name+" won the Game ");
							   return;
						   }
						   display();
					   }
					   else
					   {
						   System.out.println("invalid move");
						   i--;
					   }
					   if(total<=0)
					   {
						   System.out.println("Game Over");
						   return;
					   }
				  }
				  break;
				
		  case"n":
		       System.out.println("exit");
			   return;
		  default:
		    System.out.println("default");
			 break;
	   }
	   }
	 
   }
   public static boolean check(char piece,int x,int y)
   {
	   int diganol1=0;
	   int diganol2=0;
	   int r=0;
	   int l=0;
	   for(int i=0;i<3;i++)
	   {
		   if(piece==board[i][i])
		   {
			   diganol1++;
		   }
		   if(piece==board[3-1-i][3-1-i])
		   {
			   diganol2++;
		   }
		   if(board[x][i]==piece)
		   {
			   r++;
		   }
		   if(board[i][y]==piece)
			   l++;
	   }
	   if(diganol1==3||diganol2==3||r==3||l==3)
		   return true;
	   
	  return false;
   }
   public static void display()
   {
	   System.out.print("\t\t_ _ _ _ _ _ ");
	   for(int i=0;i<3;i++)
	   {
		   System.out.print("\n\t\t|");
		   for(int j=0;j<3;j++)
		   {
		     System.out.print(board[i][j]+" | ");
		       
		   }
		    System.out.print("\n\t\t_ _ _ _ _ _");
			
			   
	   }
	   System.out.println();
   }
   
}
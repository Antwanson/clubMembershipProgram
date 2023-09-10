// IPO
/*
Create a Database for whatever membership
This has to:
Create
Update
Record
Delete
Search for any atribute
Provide the ability or option to quit
First name, last name, Adress, Cell number, email, Membership type, Nickname, ammount of donuts eaten in one sitting. Is this person a poled
*/
import java.lang.Math;
import java.util.*;
public class coolFightClub
{

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      final int ARRAY_SIZE = 5;
      String recName = "";
      int recNum = 0;
      double recAmmount = 0;
      
      Salesperson[] Salesman;
      Salesman = new Salesperson[ARRAY_SIZE];
      for(int x = 0; x<ARRAY_SIZE;++x)
      {
         Salesman[x] = new Salesperson();
      }
      int flag = 0;
      do 
      {
         System.out.print("\n**************************************************\nPlease select from one of the following options:\n1 - Add an order\n2 - Display orders\n3 - Delete an order\n4 - Change an order ammount\n0 - QUIT\n**************************************************\n>>");
         
         flag = input.nextInt();
         input.nextLine();
         if(flag==1)
         {
            int size = ARRAY_SIZE-1;
               
            boolean hasRoom = false;
            for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
               if(Salesman[x].isSetUp!=true)
                  hasRoom=true;
               
               
               
            if(hasRoom)
            {
               System.out.print("\nPlease enter an entry number, entry numbers 0 through "+size+" are available\n>>");
               int entNum = input.nextInt(); //gets index number
               if(Salesman[entNum].isSetUp)
               {
                  System.out.println("This order entry already exists!!!"); //checks to see if order exists prints out message if it does
               }
               else
               {
               
                  System.out.print("\nPlease enter the order ID\n>>"); //order ID for order (this is not the same as index)
                  recNum = input.nextInt();
                  System.out.print("\nPlease enter the order ammount\n>>"); //Ammount of product or cash
                  recAmmount = input.nextDouble();
                  input.nextLine();
                  System.out.print("\nPlease enter the order's name\n>>"); //brief description of order to tell order apart
                  recName = input.nextLine();
                  Salesman[entNum].setData(recNum,recName,recAmmount,entNum); //calls function       
               }
            }
            else
               System.out.print("The Database is full!");
         }
         if(flag==2)
         {
            System.out.println("Orders:\n");
            boolean noOrders = true; //this variable starts as true in case there are no orders
            for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
            {
               
               if(Salesman[x].isSetUp)
               {
                  System.out.println("***********************************************************************************************************");
                  Salesman[x].display();
                     
                  noOrders=false;
               }
            }
            if(noOrders) //how error message logic happens
               System.out.print("There are currently no orders in the database, you can enter 1 to add an order.\n");
            else
               System.out.println("***********************************************************************************************************");
         }
         if(flag==3)
         {
            boolean noOrders = true;
            for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
               if(Salesman[x].isSetUp)
                  noOrders=false;
                     
            if(noOrders)
               System.out.print("There are currently no orders in the database to delete, you can enter 1 to add an order.\n");
            else
            {
               System.out.print("\nPlease enter an entry number you would like to delete\n>>");
               int entNum = input.nextInt();
               if(Salesman[entNum].isSetUp)
               {
                  Salesman[entNum].deleteData();
                  System.out.print("Entry "+ entNum+" deleted");
               }
               else
                  System.out.println("There is no order for entry that exists");
            }
         }
         if(flag==4)
         {
            boolean noOrders = true;
            for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
               if(Salesman[x].isSetUp)
                  noOrders=false;
                     
            if(noOrders)
               System.out.print("There are currently no orders in the database to change, you can enter 1 to add an order.\n");
            else
            {
               System.out.print("\nPlease enter an entry number you would like to delete\n>>");
               int entNum = input.nextInt();
               if(Salesman[entNum].isSetUp)
               {
                  System.out.print("\nPlease enter the order ammount\n>>");
                  recAmmount = input.nextDouble();
                  input.nextLine();
                  Salesman[entNum].changeData(recAmmount);
               }
               else
                  System.out.println("There is no order for entry that exists");
            }
         }
      } while (flag!=0);
      System.out.println("\nExiting...");
      
   }
   
   
}
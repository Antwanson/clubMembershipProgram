/*************************************************************************************************************************************************************************************
Create a Database for whatever membership
This has to:
Create
Update Record
Delete
Search for any atribute
Provide the ability or option to quit
First name, last name, Adress, Cell number, email, Membership type, Nickname, ammount of donuts eaten in one sitting. Is this person a poled or not. CRUD
*************************************************************************************************************************************************************************************/
import java.lang.Math;
import java.io.BufferedReader;
import java.io.FileReader;  
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.*;
public class coolFightClub
{

   public static void main(String[] args)
   {
      String recName = ""; //Most of the variables are set up here :)
      int memberAge = 0;
      String firstName = "";
      String lastName = "";
      int wonFights = 0;
      String clubMembershipLevel = "";
      String clubMembershipSearch = ""; 
      boolean activeMember = false;
      double membershipFee = 5;
      int ARRAY_SIZE = 0; //Most important variables
      String line;
      Scanner input = new Scanner(System.in); //Scanner is set up!
      clubberPerson[] Clubber;
      
      try //This try/catch just gets the array size, so that arrays that are larger than the default 5 can still use this program
      {
         BufferedReader br = new BufferedReader(new FileReader("clubMembershipArray.csv")); //Buffer is set up
         
         line = br.readLine();
         String[] databaseHeader = line.split("="); 
      
      
         ARRAY_SIZE = Integer.parseInt(databaseHeader[1]); 
         
      
      }
      catch(IOException e)
      {
         System.out.print("\nWe have noticed that you are attempting to create a new database for the club!\nPlease enter the size of your new database\n>>"); //what happens if there is no file :)
         ARRAY_SIZE = input.nextInt();
         input.nextLine();
         
      }
      
      //System.out.println("The Array Size "+ARRAY_SIZE); uncomment to check array size
      
      Clubber = new clubberPerson[ARRAY_SIZE];
      for(int x = 0; x<ARRAY_SIZE;++x)
      {
         Clubber[x] = new clubberPerson();
         
      }
      
      try   
      {  
      //parsing a CSV file into BufferedReader class constructor
        
         BufferedReader br = new BufferedReader(new FileReader("clubMembershipArray.csv"));  //allows a file to read
         br.readLine();
         int counter = 0;
         while ((line = br.readLine()) != null)   //returns a Boolean value  
         {  
            //System.out.println(line);
            
            String[] tempClub = line.split(",");    // use comma as separator
            if(Boolean.parseBoolean(tempClub[0])) //checks to see if that member was set up in the database via the initial boolean value per member.
               Clubber[counter].setData(Integer.parseInt(tempClub[1]),Integer.parseInt(tempClub[2]),tempClub[3],tempClub[4],Double.parseDouble(tempClub[5]),Boolean.parseBoolean(tempClub[6]),Integer.parseInt(tempClub[7]),tempClub[8]);
                                                              //Index,                    memberAge,  firstName,   lastName,                  membershipFee,             activeMember,                    wonFights,clubMembershipLevel);
            counter++;
         }  
      }   
      catch (IOException e)
      {
         System.out.println("New Empty Database Created, Don't forget to save!");
      }
      
      
      
      int menuFlag = 0;
      int searchFlag = 0;
      do 
      {
         System.out.print("\n**************************************************\nPlease select from one of the following options:\n1 - Add a member\n2 - Display members\n3 - Delete a member\n4 - Change a member's membership level\n5 - Search for a member\n0 - SAVE AND QUIT\n**************************************************\n>>");
         try{
            menuFlag = input.nextInt();
            input.nextLine();
            //the following are a bunch of the options in the menu controlled by the menu flag variable && user input :)
            if(menuFlag==1)
            {
               int size = ARRAY_SIZE-1;
               
               boolean hasRoom = false;
               for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
                  if(Clubber[x].isSetUp!=true)
                     hasRoom=true;
               
               
               
               if(hasRoom)
               {
                  System.out.print("\nPlease enter an entry number\n>>");
                  int entNum = input.nextInt(); //gets index number
                  input.nextLine();
                  if(Clubber[entNum].isSetUp)
                  {
                     System.out.println("This member entry already exists!!!"); //checks to see if member exists prints out message if it does
                  }
                  else
                  {
                     System.out.println("Please do not use commas when entering the following data!");
                     System.out.print("\nPlease enter the member's first name\n>>"); //First name
                     firstName = input.nextLine();
                     if (firstName.contains(",")) //throws error for commas
                     {
                        throw new InputMismatchException();
                     }
                     System.out.print("\nPlease enter the member's last name\n>>"); //last name
                     lastName = input.nextLine();
                     if (lastName.contains(",")) //throws error for commas
                     {
                        throw new InputMismatchException();
                     }
                     System.out.print("\nPlease enter the member age\n>>"); //Age for the member
                     memberAge = input.nextInt();
                     input.nextLine();
                     System.out.print("\nIs this member's membership currently active? (true or false)\n>>"); //is the member paying for the club service currently?
                     activeMember = input.nextBoolean();
                     input.nextLine();
                     System.out.print("\nEnter membership level\n>>"); //IE diamond, gold, platinum, or standard
                     clubMembershipLevel = input.nextLine();
                     if (clubMembershipLevel.contains(","))
                     {
                        throw new InputMismatchException();
                     }
                     System.out.print("\nPlease enter the member's monthly membership fee\n>>"); //Ammount of cash paid monthly
                     membershipFee = input.nextDouble();
                     input.nextLine();         
                     System.out.print("\nNumber of fights this member has won\n>>"); //How many fights have you won Dr. Azuaje?
                     wonFights = input.nextInt();
                     input.nextLine();
                     
                  
                     Clubber[entNum].setData(entNum,memberAge,firstName,lastName,membershipFee,activeMember,wonFights,clubMembershipLevel); //calls function       
                  }
               }
               else
                  System.out.print("The Database is full!");
            }
            if(menuFlag==2)
            {
               System.out.println("Orders:\n");
               boolean noOrders = true; //this variable starts as true in case there are no members
               for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
               {
               
                  if(Clubber[x].isSetUp)
                  {
                     System.out.println("*******************************************************************************************************************************************************************************************************************************************************************");
                     Clubber[x].display();
                     
                     noOrders=false;
                  }
               }
               if(noOrders) //how error message logic happens
                  System.out.print("There are currently no members in the database, you can enter 1 to add an member.\n");
               else
                  System.out.println("*******************************************************************************************************************************************************************************************************************************************************************");
            }
            if(menuFlag==3)
            {
               boolean noOrders = true;
               for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
                  if(Clubber[x].isSetUp)
                     noOrders=false;
                     
               if(noOrders)
                  System.out.print("There are currently no members in the database to delete, you can enter 1 to add an member.\n");
               else
               {
                  System.out.print("\nPlease enter an entry number you would like to delete\n>>");
                  int entNum = input.nextInt();
                  if(Clubber[entNum].isSetUp)
                  {
                     Clubber[entNum].deleteData();
                     System.out.print("Entry "+ entNum+" deleted");
                  }
                  else
                     System.out.println("There is no member for entry that exists");
               }
            }
            if(menuFlag==4)
            {
               boolean noOrders = true;
               for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
                  if(Clubber[x].isSetUp)
                     noOrders=false;
                     
               if(noOrders)
                  System.out.print("There are currently no members in the database to change, you can enter 1 to add an member.\n");
               else
               {
                  System.out.print("\nPlease enter an entry number for the member you would like to change\n>>");
                  int entNum = input.nextInt();
                  if(Clubber[entNum].isSetUp)
                  {
                     System.out.print("\nPlease enter the membership level\n>>");
                     clubMembershipLevel = input.nextLine();
                     input.nextLine();
                     System.out.print("\nPlease enter the new membership fee\n>>");
                     membershipFee = input.nextDouble();
                     input.nextLine();
                     Clubber[entNum].changeMembership(clubMembershipLevel,membershipFee);
                  }
                  else
                     System.out.println("There is no member for entry that exists");
               }
            }
            if(menuFlag==5)
            {
               boolean noOrders = true;
               for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
                  if(Clubber[x].isSetUp)
                     noOrders=false; //This variable is used later on! IF THIS IS TAMPERED WITH IT WILL SCREW UP PROGRAM - just a reminder - AZ
                     
               if(noOrders)
                  System.out.print("There are currently no members in the database to change, you can enter 1 to add an member.\n");
               else
               {
                  noOrders=true;
                  System.out.print("\n**************************************************\nPlease select from one of the following options to search by:\n1 - First and last name \n2 - First name\n3 - Last Name\n4 - Member Number\n5 - Membership Level\n**************************************************\n>>");
                  searchFlag = input.nextInt();
                  input.nextLine();
               //Start of the flags and searches :)
                  if (searchFlag ==1) //search by first and last name
                  {
                     System.out.print("\nPlease enter first name\n>>"); //gets search criteria
                     String searchFirstName = input.nextLine();
                     System.out.print("\nPlease enter last name\n>>");
                     String searchLastName = input.nextLine();
                     System.out.println();
                     for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
                     {
                     
                        if(Clubber[x].isSetUp && Clubber[x].firstName.equals(searchFirstName) && Clubber[x].lastName.equals(searchLastName)) //filter out results
                        {
                           Clubber[x].display(); 
                           noOrders=false;
                        }
                     }
                     if(noOrders)
                     {
                        System.out.print("Oops! It looks like nothing was found, try searching with different search criteria"); //What happens if nothing is pulled up!
                     }
                     
                  }
                  if (searchFlag ==2) //search by first name
                  {
                     System.out.print("\nPlease enter first name\n>>"); //gets search criteria
                     String searchFirstName = input.nextLine();
                     System.out.println();
                     for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
                     {
                     
                        if(Clubber[x].isSetUp && Clubber[x].firstName.equals(searchFirstName)) //filter out results
                        {
                           Clubber[x].display();
                           noOrders=false;
                        }
                     }
                     if(noOrders)
                     {
                        System.out.print("Oops! It looks like nothing was found, try searching with different search criteria");
                     }
                     
                  }
                  if (searchFlag ==3) //search by last name
                  {
                     System.out.print("\nPlease enter last name\n>>");
                     String searchLastName = input.nextLine();
                     System.out.println();
                     for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
                     {
                     
                        if(Clubber[x].isSetUp && Clubber[x].lastName.equals(searchLastName)) //filter out results
                        {
                           Clubber[x].display();
                           noOrders=false; 
                        }
                     }
                     if(noOrders)
                     {
                        System.out.print("Oops! It looks like nothing was found, try searching with different search criteria");
                     }
                     
                  }
                  if (searchFlag ==4) //search by Member Number
                  {
                     System.out.print("\nPlease enter member ID\n>>");
                     int searchMembNum = input.nextInt();
                     input.nextLine();
                     System.out.println();
                     for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
                     {
                     
                        if(Clubber[x].isSetUp && searchMembNum == Clubber[x].recordIndex) //filter out results
                        {
                           Clubber[x].display();
                           noOrders=false; 
                        }
                     }
                     if(noOrders)
                     {
                        System.out.print("Oops! It looks like nothing was found, try searching with different search criteria");
                     }
                     
                  }
                  if (searchFlag ==5) //search by last name
                  {
                     System.out.print("\nPlease enter member level\n>>");
                     String searchMemberLevel = input.nextLine();
                     System.out.println();
                     for(int x=0; x<ARRAY_SIZE;x++) //loop is execute until x<ARRAY_SIZE si false
                     {
                     
                        if(Clubber[x].isSetUp && Clubber[x].clubLevel.equals(searchMemberLevel)) //filter out results
                        {
                           Clubber[x].display();
                           noOrders=false; 
                        }
                     }
                     if(noOrders)
                     {
                        System.out.print("Oops! It looks like nothing was found, try searching with different search criteria");
                     }
                     
                  }
               }
            }
         }
         catch(InputMismatchException e)
         {
            System.out.print("\nERROR ERROR ERROR ERROR ERROR\nYou entered something incorrectly please try again");
            menuFlag = 99;
            input.nextLine();
         }
         catch(ArrayIndexOutOfBoundsException e)
         {
            System.out.print("\nERROR ERROR ERROR ERROR ERROR\nYou have entered an index/entry number that is out of bounds, Please try again");
            menuFlag = 99;
            input.nextLine();
         }
      } while (menuFlag!=0);
      
      System.out.println("\nSaving..."); //Displays saving to remind the user that the program is currently saving to a file :)
      
      try 
      {
         FileWriter myWriter = new FileWriter("clubMembershipArray.csv");
         //Save ALL records
         myWriter.write("arraySize="+ARRAY_SIZE+"\n");
         for(int i=0; i<ARRAY_SIZE; i++)
         {
            if(Clubber[i].isSetUp)
               myWriter.write(Clubber[i].convertAllToString()); //write record to clubMembershipArray.csv, String is already concatnated in the method, ready to be written.
            else
               myWriter.write("false\n");
         }
         myWriter.close(); //close the file : clubMembershipArray.csv
         System.out.println("Database saved successfully.");
      } catch (IOException e) {
         System.out.println("An error occurred. Project can't be saved.");
         e.printStackTrace();
      }
   
   }
   
   
}
class clubberPerson
{
   public int recordIndex = 0;
   private int memberAge = 0;
   private int fightsWon = 0;
   public String firstName = "";
   public String lastName = "";
   private double membershipFee = 0;
   public String clubLevel = "";
   private boolean currentlyActive = false;
   public boolean isSetUp = false;
   
   
   
   public void setData(int entNumber, int age, String FName,String LName, double membFee, boolean isAct, int fights, String clubLVL)
   {
      // Method to set the data to
      // student objects
      this.recordIndex = entNumber;
      
      this.memberAge = age;
      this.firstName = FName;
      this.lastName = LName;
      this.membershipFee = membFee;
      this.currentlyActive = isAct;
      this.fightsWon = fights;
      this.clubLevel = clubLVL;
      this.isSetUp = true;
      
   }
   
   public void display()
   {
      System.out.print("| ID: "+ recordIndex+ " | Member age is: " + memberAge + " | "+ "Member full name is: "+ firstName+" "+lastName +" | Member pays monthly fee of: "+ membershipFee+" | ");
      System.out.print("Active: "+currentlyActive+ " | This member has won " + fightsWon + " fights | Membership Level: "+clubLevel+"\n");
      // display() method to display
      // the record data
   }
   public void deleteData() //method "deletes" the data
   {
      this.memberAge = 0;
      this.firstName = "";
      this.lastName = "";
      this.membershipFee = 0;
      this.currentlyActive = false;
      this.fightsWon = 0;
      this.clubLevel = "";
      this.isSetUp = false; 
   }
   public void changeMembership(String clubLVL, double membFee) //method just changes order ammount
   {
      this.clubLevel = clubLVL;
      this.membershipFee = membFee;
       
   }
   public String convertAllToString()
   {
      
      String convertedString = (isSetUp+","+recordIndex+","+memberAge+","+firstName+","+lastName+","+membershipFee+","+currentlyActive+","+fightsWon+","+clubLevel+"\n"); //write record to employee.csv an place a new line feed ("\n")  at the end
      return(convertedString);
     
   
   }
}

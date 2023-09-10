class clubberPerson
{
   public int recordNumber = 0;
   public String name = "";
   public double recordAmmount = 0;
   public int recordIndex = 0;
   public boolean isSetUp = false;
   
   // Method to set the data to
   // student objects
   public void setData(int RNum, String RName, double RA, int entNumber)
   {
      this.recordNumber = RNum;
      this.name = RName;
      this.recordAmmount = RA;
      this.isSetUp = true;
      this.recordIndex = entNumber;
   }
   // display() method to display
   // the record data
   public void display()
   {
      System.out.println("| "+ recordIndex+ " | Order number is: " + recordNumber + " | "+ "and Order name is: "+ name +" | Order ammount is: "+ recordAmmount);
   }
   public void deleteData() //method "deletes" the data
   {
      this.recordNumber = 0;
      this.name = "";
      this.recordAmmount = 0;
      this.isSetUp = false;
      this.recordIndex = -1;
   }
   public void changeData(double RA) //method just changes order ammount
   {
      this.recordAmmount = RA;   
   }
}

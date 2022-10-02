// // Base class
// // Abstract
 public abstract class Account{
//   // aaccount number
   private int accountNumber;
  
//   //balance
   protected double balance;

//   // Default constracter
   public Account(){
    
 }
//   //parameter constracter 
   public Account(int accountNumber){
      this.accountNumber = accountNumber;
      balance = 0;
   }
//   // Geter methods 
   public double getBalance(){
     return this.balance;
   }

   public int getAccountNumber(){
     return this.accountNumber;
   }
//   // Abstract methods
//   /**
//    * Function to deposit funds into the account as long as the amount parameter is > 0
//    * applay trans action fee for the checking account
//    * @param amount
//   */
   public abstract void deposit(double amount);
//   // function to withdrow funds from the account
   // amount withdrow > 0
   // amount withdrow must be <= balance
   public abstract void withdraw(double amount);
}
// // Saving account child class
// // have in interst rate
// // a method to appay interst - profit
 public class SavingAccount extends Account{

  
//   // future is interst rate
   private double interestRate;

   public SavingAccount(){
    super();
   }

//   // parameter constracter to intialize SavingAccount
//   //with custem account number and interestrate
  
   public SavingAccount(int accountNumber, double interestRate){
     super(accountNumber);
     this.interestRate = interestRate;
   }
     //geter function 
   public  double getInterestRate(){
    return this.interestRate;
   }

   public void setInterestRate(double interestRate){
     this.interestRate = interestRate;
   }
//   //another function
   public double calcInterest(){
          return balance * interestRate;
   }

   public void applyInterest(){
     double interest = calcInterest();
     System.out.printf("Interest amount %.2f added to balance%n", interest);
     deposit(interest);
  }
     
// }
  
//   /**
//    * Function to deposit funds into the account as long as the amount parameter is > 0
//    * applay trans action fee for the SavingAccount
//    * @param amount
//   */
   public  void deposit(double amount){
//     // first check amount
     if(amount > 0){
       balance += amount;
       System.out.printf("Amount  %.2f deposited%n", amount);
       System.out.printf("Current Balance is: %.2f%n", balance);
    
     } else{
       System.out.println("A negative amount cant be deposited");
     }

   
    
   }
//   // function to withdrow funds from the account
//   // amount withdrow > 0
//   //amount withdrow must be <= balance
   public  void withdraw(double amount){
//     // same check
     if(amount > 0){
//       //check sufficent balance
       if((amount) <= balance){

         System.out.printf("Amount of %.2f withdrown from Account%n", amount);
         balance -= amount;
         System.out.printf("Current Balance is: %.2f%n", balance);
       }
     }else{
      
     }

       System.out.println("Negative amount cannot be withdrown");
    
   }

  
 }
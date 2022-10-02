// // Checking Account child class
 public class CheckingAccount extends Account {
//  // defoult transaction fee
  
   private static  double Fee = 2.5;

//   //defoult constracter
//   // with base class function
   public CheckingAccount(){
     super();
   }

//   // parameter constracter to intialize chechingaccount
//   //with custem account number and custem trans action fee
  
   public CheckingAccount(int accountNumber, double fee){
     super(accountNumber);
     Fee = fee;
     
   }
  
//   /**
//    * Function to deposit funds into the account as long as the amount parameter is > 0
//    * applay trans action fee for the checking account
//    * @param amount
//   */
   public  void deposit(double amount){
//     // first check amount
     if(amount > 0){
      balance += amount;
       System.out.printf("Amount  %.2f deposited%n", amount);
      
//       // Apply transaction fee
       balance -= Fee;
      System.out.printf("Fee %.2f applied%n", Fee);
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
       //check sufficent balance
      if(amount+Fee <= balance){

        System.out.printf("Amount of %.2f withdrown from Account%n", amount);
         balance -= amount;
         balance -= Fee;
          System.out.printf("Fee of %.2f applied%n", Fee);
          System.out.printf("Current Balance is: %.2f%n", balance);
       }
     }else

       System.out.println("Negative amount cannot be withdrown");
  }
 }
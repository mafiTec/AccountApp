import java.util.*;

class AccountDriver {
  
    public static void runcode() {
    
      
     Scanner keybord = new Scanner(System.in);
     // create array of Accounts
     
     //Account accounts [] = new Account[10];

     ArrayList<Account>accounts = new ArrayList<>();

      // accounts.add(new CheckingAccount(1));
      // accounts.add(new SavingAccount(2, 50));
      // accounts.add(new CheckingAccount(3));
      accounts.add(new CheckingAccount(4));

      
      


     // Account A = new Account();
     // A.menu(keybord);
      
     int numAccounts = 0;
     int  choice;

    
   
     
      do{
        
        System.out.println("Bank Account Menu");
        System.out.println("=======================");
        System.out.println("1. Creat New Account");
        System.out.println("========================");
        System.out.println("2. Deposit Fund");
        System.out.println("========================");
        System.out.println("3. withdrow Funds");
        System.out.println("========================");
        System.out.println("4. Apply Interest");
        System.out.println("========================");
        System.out.println("5.Quit");
        System.out.println("========================");
        
         
         choice = menu(keybord);
         switch(choice){
        // System.out.println();{
             
    case 1:

         if(choice == 1){
        
         // accounts[numAccounts++] = createAccount(keybord);
           accounts.add(createAccount(keybord));
           System.out.println("1. Creat New Account");
         }
        break;
    case 2:
          if(choice == 2){
           doDeposit(accounts, numAccounts, keybord);
            System.out.println("2. Deposit Fund");
          
         }
        break;
           
    case 3:
          if(choice == 3){
           doWithdraw(accounts,numAccounts, keybord);
          System.out.println("3. withdrow Funds");
      }
        break;
        
    case 4:
          if(choice == 4){
           applyInterest(accounts,numAccounts, keybord);
           System.out.println("4. Apply Interest");
          }
        break;
   case 5:
          System.out.println("GoodBye!");   
        break;
      }
          //System.out.println();
        }while(choice != 5);
   
     //System.out.println("GoodBye!");
    }

   
  
      // acount choise
      // this sub menu function
    public static int accountMenu(Scanner keybord){
       System.out.println("Select Account Type:");
       System.out.println("1. Checking Account");
       System.out.println("2. Saving Account");

    
       int choice;
     
       do{
          System.out.print("Enter Coice");
          choice = keybord.nextInt();
        }while(choice < 1 || choice < 2);

        return choice;
  
     
  }


       public static int searchAccount(ArrayList<Account> accounts,int count,int accountNumber){
         for(int i=0; i < accounts.size(); i++){
          
           if(accounts.get(i).getAccountNumber() == accountNumber){
               return i;
           }
         }
        return -1;
     }

  
           // function to perform deposit on a selected account
     public static void doDeposit(ArrayList<Account> accounts, int count, Scanner keybord){
              // get the account number
            System.out.print("\npleas enter account number");
            int accountNumber = keybord.nextInt();
            System.out.println(accountNumber);
            keybord.nextLine();

              //search for the account
            int index = searchAccount(accounts,count, accountNumber);

             if(index >= 0){
      
                 // amount 
                 System.out.print("pleas enter the amount:");
                 double amount = keybord.nextDouble();
    
                  accounts.get(index).deposit(amount);
             }else{
                  System.out.print("No account exist with AccountNumber:"+ accountNumber);
             }
       }

     public static void doWithdraw(ArrayList<Account> accounts, int count, Scanner keybord){
              // get the account nuber
             System.out.print("pleas enter account number");
             int accountNumber = keybord.nextInt();
            //search for the account
             int index = searchAccount(accounts,count, accountNumber);

          if(index >= 0){
            // amount 
             System.out.print("pleas enter withdraw amount:");
             double amount = keybord.nextDouble();
             accounts.get(index).withdraw(amount);
          }else{
            System.out.print("No account exist with AccountNumber:"+ accountNumber);
          }
    }

     public static void applyInterest(ArrayList<Account> accounts, int count, Scanner keybord){

         // get the account nuber
            System.out.print("\npleas enter account number");
            int accountNumber = keybord.nextInt();

          //search for the account
            int index = searchAccount(accounts,count, accountNumber);

          if(index >= 0){
           
             if(accounts.get(index) instanceof SavingAccount){
               ((SavingAccount)accounts.get(index)).applyInterest();
           }
          }else{
             System.out.print("No account exist with AccountNumber:"+ accountNumber);
          }
     }

    
         // function to creat a new account
     public static Account createAccount(Scanner keybord){
           Account account = null;
           int choice = accountMenu(keybord);
   
             // ask the user account number
           //int accountNumber;
            
            System.out.print("Enter Account Number:! ");
           int accountNumber = keybord.nextInt();
            keybord.nextLine();
      

         if(choice == 1){// checking account
      
             System.out.print("Enter Transaction fee");
            double fee = keybord.nextDouble();

            //creat account
            account = new CheckingAccount(accountNumber);
      
      
         }else{ // saving account
      
             System.out.print("pleas enter intereset Rate: ");
             double ir = keybord.nextDouble();
             account = new SavingAccount(accountNumber, ir);
           }
           return account;
      } 
      
      
      //   Gets the user selection 
      //  Menu display option 
     //  param keybord
     //  return 
        

  
 
     public static int menu(Scanner keybord){
       int choice = -1;

       do {
         System.out.print("Enter choice");
         try {
         choice = keybord.nextInt();  
         }catch (InputMismatchException e) {
           System.err.println("Invalid input. Please try again.");
         }
         keybord.nextLine();
       }while(choice < 1 || choice > 5);
  
        return choice;
     }
  

}
 
 import java.util.Scanner;

class Main {
    public static void main(String[] args) {
    
      
     Scanner keybord = new Scanner(System.in);
     // create array of Accounts
     Account accounts [] = new Account[10];
      
     int numAccounts = 0;
     int  choice;

    

      do{
         choice = menu(keybord);
         System.out.println();

         if(choice == 1){
        
           accounts[numAccounts++] = createAccount(keybord);
         }else if(choice == 2){
           doDeposit(accounts, numAccounts, keybord);
         }else if(choice == 3){
           doWithdraw(accounts,numAccounts, keybord);
         }else if(choice == 4){
           applyInterest(accounts,numAccounts, keybord);
         }else{
             System.out.println("GoodBye!");
          }
          System.out.println();
        }while(choice != 5);
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

    public static int searchAccount(Account accounts [],int count,int accountNumber){

        for(int i=0; i<count; i++){
          if(accounts[i].getAccountNumber() == accountNumber){
              return i;
          }
        }
              return -1;
    }

  
          // function to perform deposit on a selected account
    public static void doDeposit(Account accounts[], int count, Scanner keybord){
             // get the account nuber
           System.out.print("\npleas enter account number");
           int accountNumber = keybord.nextInt();

             //search for the account
           int index = searchAccount(accounts,count, accountNumber);

            if(index >= 0){
      
                // amount 
                System.out.print("pleas enter the amount:");
                double amount = keybord.nextDouble();
    
                 accounts[index].deposit(amount);
            }else{
                 System.out.print("No account exist with AccountNumber:"+ accountNumber);
            }
      }

    public static void doWithdraw(Account accounts [], int count, Scanner keybord){
             // get the account nuber
            System.out.print("pleas enter account number");
            int accountNumber = keybord.nextInt();
           //search for the account
            int index = searchAccount(accounts,count, accountNumber);

         if(index >= 0){
           // amount 
            System.out.print("pleas enter withdraw amount:");
            double amount = keybord.nextDouble();
            accounts[index].withdraw(amount);
         }else{
           System.out.print("No account exist with AccountNumber:"+ accountNumber);
         }
     }

    public static void applyInterest(Account accounts [], int count, Scanner keybord){

        // get the account nuber
           System.out.print("\npleas enter account number");
           int accountNumber = keybord.nextInt();

         //search for the account
           int index = searchAccount(accounts,count, accountNumber);

         if(index >= 0){
           
            if(accounts[index] instanceof SavingAccount){
              ((SavingAccount)accounts[index]).applyInterest();
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
          int accountNumber;
           System.out.print("Enter Account Number:! ");
           accountNumber = keybord.nextInt();

        if(choice == 1){// checking account
      
            System.out.print("Enter Transaction fee");
            double fee = keybord.nextDouble();

            //creat account
            account = new CheckingAccount(accountNumber, fee);
      
      
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
        
    
      System.out.println("Bank Account Menu");
      System.out.println("1. Creat New Account");
      System.out.println("2. Deposit Fund");
      System.out.println("3. withdrow Funds");
      System.out.println("4. Apply Interest");
      System.out.println("5.Quit");
   
      int choice;

      do{
        System.out.print("Enter choice");
        choice = keybord.nextInt();
      }while(choice < 1 || choice > 5);
  
       return choice;
    }

   

  

  
}
import java.util.Scanner;
class account{
   protected int i;
   protected int [] balance;
    protected int amount;

    public account(int a, int [] b){
        this.i = a;
        this.balance = new int[b.length];
        for(int i = 0; i< b.length; i++){
            this.balance[i] = b [i];
        }
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}

class functions extends account {
    public functions(int a, int[] b) {
        super(a, b);
    }

    public void deposit() {
        balance[i] += amount;
        System.out.println("Amount Deposited Successfully...");
        System.out.println(" ");
    }

    public void withdraw() {
        if (amount > balance[i]) {
            System.out.println("Insufficient Balance");
            System.out.println(" ");
        } else {
            balance[i] -= amount;
            System.out.println("Amount Withdraw Successfully...");
            System.out.println(" ");
        }
    }

    public void checkBalance() {
        System.out.println("Your Current Balance is: " + balance[i]);
        System.out.println(" ");
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] account = {9876543, 8989898};
        int[] password = {9876, 1890};
        int [] balance = {11000,45678};
        System.out.println("    Welcome to ATM Machine");
        boolean check_acc = false;
        System.out.println("Enter Account Number: ");
        int acc_user = sc.nextInt();
        System.out.println("Enter Password:");
        int pass_user = sc.nextInt();
        boolean check_pass = false;
        for(int i = 0; i < 2; i++){
            check_acc = false;
            check_pass = false;
            if(account[i] == acc_user && password [i] == pass_user){
                System.out.println("Login Successfully...");
                menu(i,balance);
                break;
            }
            if(account[i] != acc_user){
                check_acc = true;
            }
            if(password[i] != pass_user){
                check_pass = true;
            }
        }
        if(check_acc){
            System.out.println("Account number is Wrong");
        }
        if(check_pass){
            System.out.println("Password is Wrong");
        }
    }
    public static void menu(int i, int [] balance) {
        Scanner sc = new Scanner(System.in);
        functions f = new functions(i, balance);
        while (true) {
            System.out.println("-------> WELCOME TO MENU <-------");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("0. Exit");
            System.out.println("Choose: ");
            int choose = sc.nextInt();
            if (choose == 1) {
                System.out.println("Enter the Amount: ");
                int amount = sc.nextInt();
                f.setAmount(amount);
                f.deposit();
            } else if (choose == 2) {
                System.out.println("Enter the Amount: ");
                int amount = sc.nextInt();
                f.setAmount(amount);
                f.withdraw();
            } else if (choose == 3) {
                f.checkBalance();
            } else if (choose == 0) {
                System.out.println("Thank you so much for visiting us!");
                System.exit(0);
            }
        }
    }
}

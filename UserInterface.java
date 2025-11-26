import java.util.Scanner;

public class UserInterface {

    private Account[] accounts = new Account[100];
    private int count = 0;
    private Scanner sc = new Scanner(System.in);
    private int nextAccountNumber = 1001;

    private Account findAccount(int accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accNo)
                return accounts[i];
        }
        return null;
    }

    public void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        Account acc = new Account(nextAccountNumber, name, amount, email, phone);
        accounts[count++] = acc;

        System.out.println("Account created successfully! Account Number: " + nextAccountNumber);
        nextAccountNumber++;
    }

    public void performDeposit() {
        System.out.print("Enter account number: ");
        int acc = sc.nextInt();
        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account a = findAccount(acc);
        if (a != null) {
            a.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void performWithdrawal() {
        System.out.print("Enter account number: ");
        int acc = sc.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account a = findAccount(acc);
        if (a != null) {
            a.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void showAccountDetails() {
        System.out.print("Enter account number: ");
        int acc = sc.nextInt();
        sc.nextLine();

        Account a = findAccount(acc);
        if (a != null) {
            a.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    public void updateContact() {
        System.out.print("Enter account number: ");
        int acc = sc.nextInt();
        sc.nextLine();

        Account a = findAccount(acc);
        if (a != null) {
            System.out.print("Enter new email: ");
            String email = sc.nextLine();
            System.out.print("Enter new phone number: ");
            String phone = sc.nextLine();
            a.updateContactDetails(email, phone);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\n--- Banking Application ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Account Details");
            System.out.println("5. Update Contact Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: performDeposit(); break;
                case 3: performWithdrawal(); break;
                case 4: showAccountDetails(); break;
                case 5: updateContact(); break;
                case 6:
                    System.out.println("Thank you for using the banking system!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}

package meghana;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

class Account {
    
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
    
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }
    
    public int getCustomerNumber() {
        return customerNumber;
    }
    
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }
    
    public int getPinNumber() {
        return pinNumber;
    }
    
    public double getCheckingBalance() {
        return checkingBalance;
    }
    
    public double getSavingsBalance() {
        return savingBalance;
    }
    
    public double calCheckingWithdraw(double amount) {
        checkingBalance -= amount;
        return checkingBalance;
    }
    
    public double calSavingWithdraw(double amount) {
        savingBalance -= amount;
        return savingBalance;
    }
    
    public double calCheckingDeposit(double amount) {
        checkingBalance += amount;
        return checkingBalance;
    }
    
    public double calSavingDeposit(double amount) {
        savingBalance += amount;
        return savingBalance;
    }
    
    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Withdrawal Amount from checking account: ");
        double amount = input.nextDouble();
        
        if ((checkingBalance - amount) >= 0) {
            calCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Invalid balance");
        }
    }
    
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Withdrawal Amount from saving account: ");
        double amount = input.nextDouble();
        
        if ((savingBalance - amount) >= 0) {
            calSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Invalid balance");
        }
    }
    
    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to deposit into checking account: ");
        double amount = input.nextDouble();
        
        if (checkingBalance + amount >= 0) {
            calCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Invalid Balance");
        }
    }
    
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to deposit into saving account: ");
        double amount = input.nextDouble();
        
        if (savingBalance + amount >= 0) {
            calSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Invalid Balance");
        }
    }
}

class OptionMenu extends Account {
    
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<>();
    
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(952141, 191904);
                data.put(989947, 71976);
                
                System.out.println("Welcome to the ATM Project!!");
                System.out.print("Enter your customer Number: ");
                setCustomerNumber(menuInput.nextInt());
                
                System.out.print("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Invalid characters. Only numbers are allowed.");
                menuInput.next(); // clear the invalid input
                continue;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else {
                System.out.println("Wrong Customer Number or Pin number");
            }
        } while (x == 1);
    }
    
    public void getAccountType() {
        System.out.println("Select the Account: \nType 1 - Checking account\nType 2 - Saving Account\nType 3 - Exit");
        
        int selection = menuInput.nextInt();
        
        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using our ATM. Goodbye!");
                break;
            default:
                System.out.println("Please enter a valid choice");
                getAccountType();
        }
    }
    
    public void getChecking() {
        System.out.println("Checking Account: \nType 1 - View Balance\nType 2 - Withdraw Funds\nType 3 - Deposit Funds\nType 4 - Exit");
        
        int select = menuInput.nextInt();
        
        switch (select) {
            case 1:
                System.out.println("Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                getAccountType();
                break;
            default:
                System.out.println("Please enter a valid choice!!");
                getChecking();
        }
    }
    
    public void getSaving() {
        System.out.println("Savings: \nType 1 - Balance\nType 2 - Withdraw Funds\nType 3 - Deposit Funds\nType 4 - Exit");
        
        int choice = menuInput.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingsBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                getAccountType();
                break;
            default:
                System.out.println("Please enter a valid choice!!");
                getSaving();
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) throws IOException {
        OptionMenu menu = new OptionMenu();
        menu.getLogin();
    }
}

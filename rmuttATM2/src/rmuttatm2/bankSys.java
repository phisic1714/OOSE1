/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmuttatm2;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author phisic1714
 */
public class bankSys implements ATMActionable {

    private String id, name, sex, username, password;
    private int balance;
    HashMap<String, Integer> accountBalanceList = new HashMap<String, Integer>();
    HashMap<String, String> accountNameList = new HashMap<String, String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void ATMMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                           -----------------------------------------------
                           ATM Computer Thanyaburi Bank
                           -----------------------------------------------""");
        System.out.println("""
                           ////Main Menu////
                           Account ID : """ + getId());
        System.out.println("""
                           Menu Service
                           1. Account Balance
                           2. Withdraw
                           3. Deposit
                           4. Transfer
                           5. Exit""");
        System.out.print("Choose : ");
        int menuNO = input.nextInt();
        System.out.println("-----------------------------------------------\n");
        switch (menuNO) {
            case 1:
                Check();
                ATMMenu();
                break;
            case 2:
                Withdraw();
                break;

            case 3:
                Deposit();
                break;

            case 4:
                Transfer();
                break;

            case 5:
                break;

            default:
                ATMMenu();
                break;
        }
    }

    public void Check() {
        System.out.println("""
                            -----------------------------------------------
                            ATM Computer Thanyaburi Bank
                            -----------------------------------------------""");
        while (true) {
            Scanner input2 = new Scanner(System.in);
            System.out.print("Confirm Password : ");
            String confPass = input2.nextLine();
            if (!getPassword().equals(confPass)) {
                System.out.println("!!Access Denied.!!");
                System.out.println("-----------------------------------------------\n");

                break;
            }
            System.out.println("""
                                       -----------------------------------------------
                                       ////Account Balance////
                                       Account Citizen ID : """ + getId() + "\nAccount Name :" + getName() + "\nAccount Sex :" + getSex() + "\nBalance : " + getBalance() + " ฿ (Baht)");
            System.out.print("Continue?(Y/n) : ");
            String conti = input2.nextLine();
            if ("Y".equals(conti.toUpperCase())) {
                System.out.println("-----------------------------------------------\n");
                break;
            }
        }
    }

    public void Withdraw() {
        System.out.println("""
                           -----------------------------------------------
                           ATM Computer Thanyaburi Bank
                           -----------------------------------------------""");
        while (true) {
            Scanner input3 = new Scanner(System.in);
            System.out.print("Confirm Password : ");
            String confPass = input3.nextLine();
            if (!getPassword().equals(confPass)) {
                System.out.println("!!Access Denied.!!");
                ATMMenu();
            }
            System.out.println("""
                                       -----------------------------------------------
                                       ////Withdraw////
                                       Account Citizen ID : """ + getId());
            System.out.print("Enter Amount : ");
            int newBalance = input3.nextInt();
            int balance = getBalance() - newBalance;
            if (newBalance > getBalance()) {
                System.out.println("""
                                           -----------------------------------------------
                                           !!Insufficient Funds!!
                                           -----------------------------------------------""");
                ATMMenu();
            } else {
                setBalance(balance);
                System.out.println("-----------------------------------------------\n");
                System.out.println("Your Balance is '" + getBalance() + "'");
                System.out.println("-----------------------------------------------\n");
                ATMMenu();
                break;
            }
        }

    }

    public void Deposit() {
        System.out.println("""
                           -----------------------------------------------
                           ATM Computer Thanyaburi Bank
                           -----------------------------------------------""");
        while (true) {
            Scanner input3 = new Scanner(System.in);
            System.out.print("Confirm Password : ");
            String confPass = input3.nextLine();
            if (!getPassword().equals(confPass)) {
                System.out.println("!!Access Denied.!!");
                System.out.println("-----------------------------------------------\n");
                ATMMenu();
            }
            System.out.println("""
                                       -----------------------------------------------
                                       ////Deposite////
                                       Account Citizen ID : """ + getId());
            System.out.print("Enter Deposit Amount : ");
            int newBalance = input3.nextInt();
            int balance = getBalance() + newBalance;
            if (balance > 1000000) {
                System.out.println("""
                                           -----------------------------------------------
                                           !!Over Limit!!
                                           -----------------------------------------------""");
                ATMMenu();
            } else {
                setBalance(balance);
                System.out.println("-----------------------------------------------\n");
                System.out.println("Your Balance is '" + getBalance() + "'");
                System.out.println("-----------------------------------------------\n");
                ATMMenu();
                break;
            }
        }

    }

    public void Transfer() {
        System.out.println("""
                           -----------------------------------------------
                           ATM Computer Thanyaburi Bank
                           -----------------------------------------------""");
        while (true) {
            Scanner input3 = new Scanner(System.in);
            System.out.print("Confirm Password : ");
            String confPass = input3.nextLine();
            if (!getPassword().equals(confPass)) {
                System.out.println("!!Access Denied.!!");
                System.out.println("-----------------------------------------------\n");
                ATMMenu();
            }
            System.out.println("""
                                       -----------------------------------------------
                                       ////Transfer////
                                       Account Citizen ID : """ + getId());
            System.out.print("Enter Destination Account Citizen ID : ");
            String destiAc = input3.nextLine();
            System.out.print("Destination Account Citizen Name : " + accountNameList.get(destiAc) + "\n");
            System.out.print("Enter Tranfer Amount : ");
            int newBalance = input3.nextInt();
            int balance = getBalance() - newBalance;
            if (balance <= 0) {
                System.out.println("""
                                           -----------------------------------------------
                                           !!Insufficient Funds!!
                                           -----------------------------------------------""");
                ATMMenu();
            }
            int desBalance = accountBalanceList.get(destiAc) + newBalance;
            if (desBalance > 1000000) {
                System.out.println("""
                                           -----------------------------------------------
                                           !!Over Limit!!
                                           -----------------------------------------------""");
                ATMMenu();
            } else {
                accountBalanceList.put(destiAc, desBalance);
                setBalance(balance);
                System.out.println("-----------------------------------------------\n" + "!!Transfer to '" + accountNameList.get(destiAc) + "' is Complete!!");
                System.out.println("Your Balance is '" + getBalance() + "'");
                System.out.println("-----------------------------------------------\n");
                break;
            }
        }

    }
}

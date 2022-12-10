/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmuttatm;

import java.util.Scanner;

/**
 *
 * @author phisic1714
 */
public class bankSys {

    private String id, name, pass;
    private int balance;

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void accountInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Account ID(13 Digit)= ");
        String id = input.nextLine();
        while (id.length() != 13) {
            System.out.print("!!You must Enter Account ID 13 Digit!!\n" + "Account ID(13 Digit)= ");
            id = input.nextLine();
        }
        System.out.print("Account Name(less than 50 Digit)= ");
        String name = input.nextLine();
        while (name.length() > 50) {
            System.out.print("!!You must Enter Account Name less than 50 Digit!!\n" + "Account Name(less than 50 Digit)= ");
            name = input.nextLine();
        }

        System.out.print("Password(4 Digit)= ");
        String pass = input.nextLine();
        while (pass.length() != 4) {
            System.out.print("!!You must Enter Password 4 Digit!!\n" + "Password(4 Digit)= ");
            pass = input.nextLine();
        }
        System.out.print("Balance(Limit at 1 Million Baht)= ");
        int balance = input.nextInt();
        while (balance > 1000000) {
            System.out.print("!!You must Enter Balance less than 1 Million Baht!!\n" + "Balance(Limit at 1 Million Baht)= ");
            balance = input.nextInt();
        }

        setId(id);
        setName(name);
        setPass(pass);
        setBalance(balance);
    }

    public void ATMMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------\n" + "ATM Computer Thanyaburi Bank" + "\n-----------------------------------------------");
        System.out.println("////Main Menu////\n" + "Account ID : " + getId());
        System.out.println("Menu Service" + "\n1. Account Balance" + "\n2. Withdraw" + "\n3. Exit");
        System.out.print("Choose : ");
        int menuNO = input.nextInt();
        System.out.println("-----------------------------------------------\n");
        switch (menuNO) {
            case 1:
                System.out.println("-----------------------------------------------\n" + "ATM Computer Thanyaburi Bank" + "\n-----------------------------------------------");
                while (true) {
                    Scanner input2 = new Scanner(System.in);
                    System.out.print("Confirm Password : ");
                    String confPass = input2.nextLine();
                    if (!getPass().equals(confPass)) {
                        System.out.println("!!Access Denied.!!");
                        break;
                    }
                    System.out.println("-----------------------------------------------\n" + "////Account Balance////\n" + "Account ID : " + getId() + "\nAccount Name :" + getName() + "\nBalance : " + getBalance() + " ฿ (Baht)");
                    System.out.print("Continue?(Y/n) : ");
                    String conti = input2.nextLine();
                    if ("y".equals(conti) || "Y".equals(conti)) {
                        break;
                    }
                    System.out.println("-----------------------------------------------\n");
                }
                System.out.println("-----------------------------------------------\n");
                ATMMenu();
                break;
            case 2:
                System.out.println("-----------------------------------------------\n" + "ATM Computer Thanyaburi Bank" + "\n-----------------------------------------------");
                while (true) {
                    Scanner input3 = new Scanner(System.in);
                    System.out.print("Confirm Password : ");
                    String confPass = input3.nextLine();
                    if (!getPass().equals(confPass)) {
                        System.out.println("!!Access Denied.!!");
                        break;
                    }
                    System.out.println("-----------------------------------------------\n" + "////Withdraw////\n" + "Account ID : " + getId());
                    System.out.print("Enter Amount : ");
                    int newBalance = input3.nextInt();
                    int balance = getBalance() - newBalance;
                    if (newBalance > getBalance()) {
                        System.out.println("-----------------------------------------------\n" + "!!Insufficient funds!!" );
                        break;
                    } else {
                        System.out.println("-----------------------------------------------\n");
                        setBalance(balance);
                        break;
                    }
                }
                System.out.println("-----------------------------------------------\n");
                ATMMenu();
                break;

            case 3:
                break;

            default:
                ATMMenu();
                break;
        }
    }

}

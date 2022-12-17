/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmuttatm2;

import java.util.Scanner;

/**
 *
 * @author phisic1714
 */
public class Manager extends Person {

    boolean ATMLoop;

    public void managerInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Manager Username= ");
        String username = input.nextLine();

        System.out.print("Manager Password(4 Digit)= ");
        String password = input.nextLine();
        while (password.length() != 4) {
            System.out.print("""
                             !!You must Enter Manager Password 4 Digit!!
                            Manager Password(4 Digit)= """);
            password = input.nextLine();
        }
        System.out.println("""
                                  ****************************************
                                   !!Complete.!!
                                  **************************************** """);

        setUsername(username);
        setPassword(password);
    }

    public void managerATM() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                           -----------------------------------------------
                           ATM Computer Thanyaburi Bank
                           -----------------------------------------------""");
        System.out.println("""
                           ////Main Menu////
                           Manager ID : """ + getId());
        System.out.println("""
                           Manager Menu Service
                           1. Manager Information
                           2. Check Accounts List
                           3. Reset Accounts
                           4. Exit""");
        System.out.print("Choose : ");
        int menuNO = input.nextInt();
        System.out.println("-----------------------------------------------\n");
        switch (menuNO) {
            case 1:
                managerInfo();
                managerATM();
                break;
            case 2:
                accountList();
                managerATM();
                break;

            case 3:
                ATMLoop = false;
                break;

            case 4:
                break;

            default:
                managerATM();
                break;
        }

    }

    public void managerInfo() {
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
                       ////Manager Infomation////
                       Manager Citizen ID : """ + getId() + "\nManager Name :" + getName() + "\nManager Sex :" + getSex());
            System.out.print("Continue?(Y/n) : ");
            String conti = input2.nextLine();
            if ("Y".equals(conti.toUpperCase())) {
                System.out.println("-----------------------------------------------\n");
                break;

            }

        }
    }

    public void accountList() {
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
                           ////Accounts List////""");
            int Count=1;
            for (String i : accountBalanceList.keySet()) {
                if(i != null){
                System.out.println("No. " +Count++ +"\nAccount Citizen : "+ i + "\nAccount Balance : " + accountBalanceList.get(i));}
            }
            System.out.print("\nContinue?(Y/n) : ");
            String conti = input2.nextLine();
            if ("Y".equals(conti.toUpperCase())) {
                System.out.println("-----------------------------------------------\n");
                break;

            }

        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rmuttatm;

import java.util.Scanner;

/**
 *
 * @author phisic1714
 */

public class RmuttATM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        bankSys account1 = new bankSys();
        bankSys account2 = new bankSys();
        bankSys account3 = new bankSys();                   
        bankSys account4 = new bankSys();
        bankSys account5 = new bankSys();
        bankSys account6 = new bankSys();

        System.out.print("********************************************************************************\n" + "*Wellcome to RMUTT Engineering Banking System*" + "\n********************************************************************************\n" );
        System.out.print("Enter amount of all account(Limit 6 Account) = ");
        int amountAc = input.nextInt();
        if (amountAc > 6) {
            System.out.println("!!You enter more than 6 Account!!");
            main(args);
        }
        System.out.println("Enter Detail of each account.");
        for (int i = 1; i <= amountAc; i++) {
            System.out.println("\nNo." + i);
            switch (i) {
                case 1:
                    account1.accountInput();
                    break;
                case 2:
                    account2.accountInput();
                    while (account2.getId().equals(account1.getId())) {
                        System.out.println("\n!!This Account ID already exist.!! Please Re-Assign account No.2\n");
                        account2.accountInput();
                    }
                    break;
                case 3:
                    account3.accountInput();
                    while (account3.getId().equals(account1.getId()) || account3.getId().equals(account2.getId())) {
                        System.out.println("\n!!This Account ID already exist.!! Please Re-Assign account No.3\n");
                        account3.accountInput();
                    }
                    break;
                case 4:
                    account4.accountInput();
                    while (account4.getId().equals(account1.getId()) || account4.getId().equals(account2.getId()) || account4.getId().equals(account3.getId())) {
                        System.out.println("\n!!This Account ID already exist.!! Please Re-Assign account No.4\n");
                        account4.accountInput();
                    }
                    break;
                case 5:
                    account5.accountInput();
                    while (account5.getId().equals(account1.getId()) || account5.getId().equals(account2.getId()) || account5.getId().equals(account3.getId()) || account5.getId().equals(account4.getId())) {
                        System.out.println("\n!!This Account ID already exist.!! Please Re-Assign account No.5\n");
                        account5.accountInput();
                    }
                    break;
                case 6:
                    account6.accountInput();
                    while (account6.getId().equals(account1.getId()) || account6.getId().equals(account2.getId()) || account6.getId().equals(account3.getId()) || account6.getId().equals(account4.getId()) || account6.getId().equals(account5.getId())) {
                        System.out.println("\n!!This Account ID already exist.!! Please Re-Assign account No.6\n");
                        account6.accountInput();
                    }
                    break;
                default:
                    break;
            }

        }
        System.out.println("********************************************************************************\n");

        while (true) {
            Scanner input2 = new Scanner(System.in);
            System.out.println("-----------------------------------------------\n" + "ATM Computer Thanyaburi Bank" + "\n-----------------------------------------------");
            System.out.print("////Log In////\n" + "Account ID : ");
            String idIn = input2.nextLine();
            System.out.print("Account Password  : ");
            String passIn = input2.nextLine();
            if (idIn.equals(account1.getId()) && passIn.equals(account1.getPass())) {
                System.out.println("-----------------------------------------------\n");
                account1.ATMMenu();
            } else if (idIn.equals(account2.getId()) || passIn.equals(account2.getPass())) {
                System.out.println("-----------------------------------------------\n");
                account2.ATMMenu();
            } else if (idIn.equals(account3.getId()) || passIn.equals(account3.getPass())) {
                System.out.println("-----------------------------------------------\n");
                account3.ATMMenu();
            } else if (idIn.equals(account4.getId()) || passIn.equals(account4.getPass())) {
                System.out.println("-----------------------------------------------\n");
                account4.ATMMenu();
            } else if (idIn.equals(account5.getId()) || passIn.equals(account5.getPass())) {
                System.out.println("-----------------------------------------------\n");
                account5.ATMMenu();
            } else if (idIn.equals(account6.getId()) || passIn.equals(account6.getPass())) {
                System.out.println("-----------------------------------------------\n");
                account6.ATMMenu();
            } else {
                System.out.println("-----------------------------------------------\n" + "!!Access Denied.!!" + "\n-----------------------------------------------");
            }

        }

    }

}

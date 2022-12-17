/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rmuttatm2;

import java.util.Scanner;

/**
 *
 * @author phisic1714
 */
public class RmuttATM2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager manager = new Manager();
        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();
        Account account4 = new Account();
        Account account5 = new Account();
        Account account6 = new Account();
        
        /* เข้าสู่ระบบธนาคาร */
        while (true) {
            /* ส่วนของผู้จัดการระบบธนาคาร */
            System.out.print("""
                    ********************************************************************************
                                 *Wellcome to RMUTT Engineering Banking System*
                    ********************************************************************************
                    """);

            // ส่วน Login และ Register ของ ผู้จัดการ
            boolean loop = true;
            while (loop == true) {
                Scanner input = new Scanner(System.in);
                System.out.println("""
                        Please Select Menu
                        1. Manager Log In
                        2. Manager Register """);

                System.out.print("Choose : ");
                int menuNO = input.nextInt();
                switch (menuNO) {
                    case 1:
                        break;
                    case 2:
                        System.out.print("////Manager Register////\n");
                        manager.register();
                        manager.managerInput();
                        break;
                    default:
                        break;
                }
                Scanner input2 = new Scanner(System.in);
                System.out.print("////Manager Log In////\nManager Username = ");
                String managerId = input2.nextLine();
                System.out.print("Manager Password = ");
                String managerPass = input2.nextLine();
                if (!managerId.equals(manager.getUsername()) || !managerPass.equals(manager.getPassword())) {
                    System.out.println("""
                            ****************************************
                             !!Access Denied.!!
                            **************************************** """);
                } else {
                    System.out.println("""
                            ****************************************
                             !!Complete.!!
                            **************************************** """);
                    loop = false;
                }
            }

            // ส่วนกำหนดจำนวน ผู้ใช้งาน
            int amountAc = 0;
            boolean loop2 = true;
            while (loop2 == true) {
                Scanner input = new Scanner(System.in);
                 System.out.println("""
                        ////Account Assign////
                        Please Select Menu
                        1. Setting Account
                        2. ATM Menu """);
                System.out.print("Choose : ");
                int menuNO = input.nextInt();
                switch (menuNO){
                    case 1:
                System.out.print("Enter amount of all account(Limit 6 Account) = ");
                amountAc = input.nextInt();
                if (amountAc > 6) {
                    System.out.println("!!You enter more than 6 Account!!");
                } else {
                    loop2 = false;
                }
               default:
                 loop2 = false;
            }
            }
            // ส่วนกำหนดข้อมูล ผู้ใช้งาน
            if(amountAc!=0){
            System.out.println("Enter Detail of each account.");}
            for (int i = 1; i <= amountAc; i++) {
                System.out.println("\nNo." + i);
                switch (i) {
                    case 1:
                        account1.register();
                        account1.accountInput();
                        break;
                    case 2:
                        account2.register();
                        account2.accountInput();
                        while (account2.getUsername().equals(account1.getUsername())) {
                            System.out.println(
                                    "\n!!This Account Username already exist.!! Please Re-Assign account No.2\n");
                            account2.accountInput();
                        }
                        break;
                    case 3:
                        account3.register();
                        account3.accountInput();
                        while (account3.getUsername().equals(account1.getUsername())
                                || account3.getUsername().equals(account2.getUsername())) {
                            System.out.println(
                                    "\n!!This Account Username already exist.!! Please Re-Assign account No.3\n");
                            account3.accountInput();
                        }
                        break;
                    case 4:
                        account4.register();
                        account4.accountInput();
                        while (account4.getUsername().equals(account1.getUsername())
                                || account4.getUsername().equals(account2.getUsername())
                                || account4.getUsername().equals(account3.getUsername())) {
                            System.out.println(
                                    "\n!!This Account Username already exist.!! Please Re-Assign account No.4\n");
                            account4.accountInput();
                        }
                        break;
                    case 5:
                        account5.register();

                        account5.accountInput();
                        while (account5.getUsername().equals(account1.getUsername())
                                || account5.getUsername().equals(account2.getUsername())
                                || account5.getUsername().equals(account3.getUsername())
                                || account5.getUsername().equals(account4.getUsername())) {
                            System.out.println(
                                    "\n!!This Account Username already exist.!! Please Re-Assign account No.5\n");
                            account5.accountInput();
                        }
                        break;
                    case 6:
                        account6.register();
                        account6.accountInput();
                        while (account6.getUsername().equals(account1.getUsername())
                                || account6.getUsername().equals(account2.getUsername())
                                || account6.getUsername().equals(account3.getUsername())
                                || account6.getUsername().equals(account4.getUsername())
                                || account6.getUsername().equals(account5.getUsername())) {
                            System.out.println(
                                    "\n!!This Account Username already exist.!! Please Re-Assign account No.6\n");
                            account6.accountInput();
                        }
                        break;
                    default:
                        break;
                }

            }
            System.out.println("********************************************************************************\n");

            /* ส่วนของผู้ใช้งานตู้ ATM */
            manager.ATMLoop = true;
            while (manager.ATMLoop) {
                Scanner input = new Scanner(System.in);
                System.out.println("""
                        -----------------------------------------------
                          ATM Computer Thanyaburi Bank
                        -----------------------------------------------""");
                // ส่วน Login เข้าบัญชีธนาคาร
                System.out.print("""
                        ////Log In////
                        Account Username : """);
                String userIn = input.nextLine();
                System.out.print("Account Password  : ");
                String passIn = input.nextLine();
                if (userIn.equals(manager.getUsername()) || passIn.equals(manager.getPassword())) {
                    manager.accountBalanceList.put(account1.getId(), account1.getBalance());
                    manager.accountBalanceList.put(account2.getId(), account2.getBalance());
                    manager.accountBalanceList.put(account3.getId(), account3.getBalance());
                    manager.accountBalanceList.put(account4.getId(), account4.getBalance());
                    manager.accountBalanceList.put(account5.getId(), account5.getBalance());
                    manager.accountBalanceList.put(account6.getId(), account6.getBalance());
                    manager.managerATM();
                } else if (userIn.equals(account1.getUsername()) || passIn.equals(account1.getPassword())) {
                    System.out.println("-----------------------------------------------\n");
                    account1.accountBalanceList.put(account2.getId(), account2.getBalance());
                    account1.accountNameList.put(account2.getId(), account2.getName());
                    account1.accountBalanceList.put(account3.getId(), account3.getBalance());
                    account1.accountNameList.put(account3.getId(), account3.getName());
                    account1.accountBalanceList.put(account4.getId(), account4.getBalance());
                    account1.accountNameList.put(account4.getId(), account4.getName());
                    account1.accountBalanceList.put(account5.getId(), account5.getBalance());
                    account1.accountNameList.put(account5.getId(), account5.getName());
                    account1.accountBalanceList.put(account6.getId(), account6.getBalance());
                    account1.accountNameList.put(account6.getId(), account6.getName());
                    account1.ATMMenu();
                    account2.setBalance(account1.accountBalanceList.get(account2.getId()));
                    account3.setBalance(account1.accountBalanceList.get(account3.getId()));
                    account4.setBalance(account1.accountBalanceList.get(account4.getId()));
                    account5.setBalance(account1.accountBalanceList.get(account5.getId()));
                    account6.setBalance(account1.accountBalanceList.get(account6.getId()));
                } else if (userIn.equals(account2.getUsername()) || passIn.equals(account2.getPassword())) {
                    System.out.println("-----------------------------------------------\n");
                    account2.accountBalanceList.put(account1.getId(), account1.getBalance());
                    account2.accountNameList.put(account1.getId(), account1.getName());
                    account2.accountBalanceList.put(account3.getId(), account3.getBalance());
                    account2.accountNameList.put(account3.getId(), account3.getName());
                    account2.accountBalanceList.put(account4.getId(), account4.getBalance());
                    account2.accountNameList.put(account4.getId(), account4.getName());
                    account2.accountBalanceList.put(account5.getId(), account5.getBalance());
                    account2.accountNameList.put(account5.getId(), account5.getName());
                    account2.accountBalanceList.put(account6.getId(), account6.getBalance());
                    account2.accountNameList.put(account6.getId(), account6.getName());
                    account2.ATMMenu();
                    account1.setBalance(account2.accountBalanceList.get(account1.getId()));
                    account3.setBalance(account2.accountBalanceList.get(account3.getId()));
                    account4.setBalance(account2.accountBalanceList.get(account4.getId()));
                    account5.setBalance(account2.accountBalanceList.get(account5.getId()));
                    account6.setBalance(account2.accountBalanceList.get(account6.getId()));
                } else if (userIn.equals(account3.getUsername()) || passIn.equals(account3.getPassword())) {
                    System.out.println("-----------------------------------------------\n");
                    account3.accountBalanceList.put(account1.getId(), account1.getBalance());
                    account3.accountNameList.put(account1.getId(), account1.getName());
                    account3.accountBalanceList.put(account2.getId(), account2.getBalance());
                    account3.accountNameList.put(account2.getId(), account2.getName());
                    account3.accountBalanceList.put(account4.getId(), account4.getBalance());
                    account3.accountNameList.put(account4.getId(), account4.getName());
                    account3.accountBalanceList.put(account5.getId(), account5.getBalance());
                    account3.accountNameList.put(account5.getId(), account5.getName());
                    account3.accountBalanceList.put(account6.getId(), account6.getBalance());
                    account3.accountNameList.put(account6.getId(), account6.getName());
                    account3.ATMMenu();
                    account1.setBalance(account3.accountBalanceList.get(account1.getId()));
                    account2.setBalance(account3.accountBalanceList.get(account2.getId()));
                    account4.setBalance(account3.accountBalanceList.get(account4.getId()));
                    account5.setBalance(account3.accountBalanceList.get(account5.getId()));
                    account6.setBalance(account3.accountBalanceList.get(account6.getId()));
                } else if (userIn.equals(account4.getUsername()) || passIn.equals(account4.getPassword())) {
                    System.out.println("-----------------------------------------------\n");
                    account4.accountBalanceList.put(account1.getId(), account1.getBalance());
                    account4.accountNameList.put(account1.getId(), account1.getName());
                    account4.accountBalanceList.put(account2.getId(), account2.getBalance());
                    account4.accountNameList.put(account2.getId(), account2.getName());
                    account4.accountBalanceList.put(account3.getId(), account3.getBalance());
                    account4.accountNameList.put(account3.getId(), account3.getName());
                    account4.accountBalanceList.put(account5.getId(), account5.getBalance());
                    account4.accountNameList.put(account5.getId(), account5.getName());
                    account4.accountBalanceList.put(account6.getId(), account6.getBalance());
                    account4.accountNameList.put(account6.getId(), account6.getName());
                    account4.ATMMenu();
                    account1.setBalance(account4.accountBalanceList.get(account1.getId()));
                    account2.setBalance(account4.accountBalanceList.get(account2.getId()));
                    account3.setBalance(account4.accountBalanceList.get(account3.getId()));
                    account5.setBalance(account4.accountBalanceList.get(account5.getId()));
                    account6.setBalance(account4.accountBalanceList.get(account6.getId()));
                } else if (userIn.equals(account5.getUsername()) || passIn.equals(account5.getPassword())) {
                    System.out.println("-----------------------------------------------\n");
                    account5.accountBalanceList.put(account1.getId(), account1.getBalance());
                    account5.accountNameList.put(account1.getId(), account1.getName());
                    account5.accountBalanceList.put(account2.getId(), account2.getBalance());
                    account5.accountNameList.put(account2.getId(), account2.getName());
                    account5.accountBalanceList.put(account3.getId(), account3.getBalance());
                    account5.accountNameList.put(account3.getId(), account3.getName());
                    account5.accountBalanceList.put(account4.getId(), account4.getBalance());
                    account5.accountNameList.put(account4.getId(), account4.getName());
                    account5.accountBalanceList.put(account6.getId(), account6.getBalance());
                    account5.accountNameList.put(account6.getId(), account6.getName());
                    account5.ATMMenu();
                    account1.setBalance(account5.accountBalanceList.get(account1.getId()));
                    account2.setBalance(account5.accountBalanceList.get(account2.getId()));
                    account3.setBalance(account5.accountBalanceList.get(account3.getId()));
                    account4.setBalance(account5.accountBalanceList.get(account4.getId()));
                    account6.setBalance(account5.accountBalanceList.get(account6.getId()));
                } else if (userIn.equals(account6.getUsername()) || passIn.equals(account6.getPassword())) {
                    System.out.println("-----------------------------------------------\n");
                    account6.accountBalanceList.put(account1.getId(), account1.getBalance());
                    account6.accountNameList.put(account1.getId(), account1.getName());
                    account6.accountBalanceList.put(account2.getId(), account2.getBalance());
                    account6.accountNameList.put(account2.getId(), account2.getName());
                    account6.accountBalanceList.put(account3.getId(), account3.getBalance());
                    account6.accountNameList.put(account3.getId(), account3.getName());
                    account6.accountBalanceList.put(account4.getId(), account4.getBalance());
                    account6.accountNameList.put(account4.getId(), account4.getName());
                    account6.accountBalanceList.put(account5.getId(), account5.getBalance());
                    account6.accountNameList.put(account5.getId(), account5.getName());
                    account6.ATMMenu();
                    account1.setBalance(account6.accountBalanceList.get(account1.getId()));
                    account2.setBalance(account6.accountBalanceList.get(account2.getId()));
                    account3.setBalance(account6.accountBalanceList.get(account3.getId()));
                    account4.setBalance(account6.accountBalanceList.get(account4.getId()));
                    account5.setBalance(account6.accountBalanceList.get(account5.getId()));
                } else {
                    System.out.println("""
                            -----------------------------------------------
                            !!Access Denied.!!
                            -----------------------------------------------""");
                }

            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rmuttatm3;

import java.util.Scanner;

/**
 *
 * @author phisic1714
 */
public class RmuttATM3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager manager = new Manager();
        Account account = new Account();

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
                    case 1 -> {
                    }
                    case 2 -> {
                        System.out.print("////Manager Register////\n");
                        manager.register();
                        manager.managerInput();
                        account.checkID.add(manager.getId());
                        account.checkUsername.add(manager.getUsername());
                    }
                    default -> {
                    }
                }
                Scanner input2 = new Scanner(System.in);
                System.out.print("////Manager Log In////\nManager Username = ");
                String managerUser = input2.nextLine();
                System.out.print("Manager Password = ");
                String managerPass = input2.nextLine();
                if (!managerPass.equals(manager.getPassword())) {
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

            // ส่วนกำหนดจำนวน แบงค์และค่าเงิน
            account.ATMSetup();

            // ส่วนกำหนดจำนวน ผู้ใช้งาน
            int amountAc = 0;
            Scanner ACinput = new Scanner(System.in);
            System.out.print(" ////Account Assign////\nEnter amount of all account = ");
            amountAc = ACinput.nextInt();

            // ส่วนกำหนดข้อมูล ผู้ใช้งาน
            if (amountAc != 0) {
                System.out.println("Enter Detail of each account.");
            }
            int j = -1;
            for (int i = 1; i <= amountAc; i++) {
                j++;
                System.out.println("No." + i);
                account.register();
                account.accountInput();
                account.checkID.add((String) account.ID.values().toArray()[j]);
                account.checkUsername.add((String) account.UserNPassN.keySet().toArray()[j]);


                /*1163104620187
                  1111111111111
                  2222222222222  
                 */
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
                System.out.print("Account Password : ");
                String passIn = input.nextLine();
                String pass = account.UserNPassN.get(userIn);
                if (userIn.equals(manager.username)) {
                    manager.BalanceList = account.Balance;
                    manager.managerATM();
                } else if (pass.equals(passIn)) {
                    account.ATMMenu(userIn);
                } else {
                    System.out.println("""
                            -----------------------------------------------
                            !!Access Denied.!!
                            -----------------------------------------------""");
                }

            }
            account.UserNPassN.clear();
            account.ID.clear();
            account.Name.clear();
            account.Sex.clear();
            account.Balance.clear();
            account.BTC.clear();
            account.checkUsername.clear();
            account.checkID.clear();
        }
    }
}

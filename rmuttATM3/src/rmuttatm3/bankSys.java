/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmuttatm3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author phisic1714
 */
public class bankSys implements ATMActionable {

    String username, password, id, name, sex;
    float balance, btc, btcCurrency;
    ArrayList<Integer> Banknote = new ArrayList<Integer>();
    HashMap<String, String> UserNPassN = new HashMap<String, String>();
    HashMap<String, String> ID = new HashMap<String, String>();
    HashMap<String, String> Name = new HashMap<String, String>();
    HashMap<String, String> Sex = new HashMap<String, String>();
    HashMap<String, Float> Balance = new HashMap<String, Float>();
    HashMap<String, Float> BTC = new HashMap<String, Float>();

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

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getBtc() {
        return btc;
    }

    public void setBtc(float btc) {
        this.btc = btc;
    }

    public float getBtcCurrency() {
        return btcCurrency;
    }

    public void setBtcCurrency(float btcCurrency) {
        this.btcCurrency = btcCurrency;
    }

    public void ATMSetup() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                           -----------------------------------------------
                           Menu ATM Setup
                           1. Add Banknote
                           2. Add Bitcoin Currency
                           3. Exit""");
        System.out.print("Choose : ");
        int menuNO = input.nextInt();
        System.out.println("-----------------------------------------------\n");
        switch (menuNO) {
            case 1:
                System.out.println("""
                           Please Insert Banknote
                           -----------------------------------------------""");
                System.out.print("100 Bath Amount = ");
                int hundred = input.nextInt();
                System.out.print("500 Bath Amount = ");
                int Fivehundred = input.nextInt();
                System.out.print("1000 Bath Amount = ");
                int Thousan = input.nextInt();
                Banknote.add(0, hundred);
                Banknote.add(1, Fivehundred);
                Banknote.add(2, Thousan);
                ATMSetup();
                break;
            case 2:
                System.out.println("""
                           Please Entry Bitcoin Currency
                           -----------------------------------------------""");
                System.out.print("1 BTC = ");
                float btcCurrency = input.nextFloat();
                setBtcCurrency(btcCurrency);
                ATMSetup();
                break;

            case 3:
                break;

            default:
                ATMSetup();
                break;
        }
    }

    public void ATMMenu(String CurrentUsername) {
        String CurrentUserID = ID.get(UserNPassN.get(CurrentUsername));
        Scanner input = new Scanner(System.in);
        System.out.println("""
                           -----------------------------------------------
                           ATM Computer Thanyaburi Bank
                           -----------------------------------------------""");
        System.out.println("""
                           ////Main Menu////
                           Account ID : """ + CurrentUserID);
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
                Check(CurrentUsername, CurrentUserID);
                ATMMenu(CurrentUsername);
                break;
            case 2:
                Withdraw(CurrentUsername, CurrentUserID);
                break;

            case 3:
                Deposit(CurrentUsername, CurrentUserID);
                break;

            case 4:
                Transfer(CurrentUsername, CurrentUserID);
                break;

            case 5:
                break;

            default:
                ATMMenu(CurrentUsername);
                break;
        }
    }

    public void Check(String CurrentUsername, String CurrentUserID) {
        System.out.println("""
                            -----------------------------------------------
                            ATM Computer Thanyaburi Bank
                            -----------------------------------------------""");
        while (true) {
            Scanner input2 = new Scanner(System.in);
            System.out.print("Confirm Password : ");
            String confPass = input2.nextLine();
            if (!UserNPassN.get(CurrentUsername).equals(confPass)) {
                System.out.println("!!Access Denied.!!");
                System.out.println("-----------------------------------------------\n");

                break;
            }
            System.out.println("""
                                       -----------------------------------------------
                                       ////Account Balance////
                                       Account Citizen ID : """ + CurrentUserID + "\nAccount Name : " + Name.get(CurrentUserID) + "\nAccount Sex :" + Sex.get(CurrentUserID) + "\nBalance : " + Balance.get(CurrentUserID) + " Baht" + "\nBitcoin : " + BTC.get(CurrentUserID) + " BTC");
            System.out.print("Continue?(Y/n) : ");
            String conti = input2.nextLine();
            if ("Y".equals(conti.toUpperCase())) {
                System.out.println("-----------------------------------------------\n");
                break;
            }
        }
    }

    public void Withdraw(String CurrentUsername, String CurrentUserID) {
        System.out.println("""
                           -----------------------------------------------
                           ATM Computer Thanyaburi Bank
                           -----------------------------------------------""");
        while (true) {
            Scanner input3 = new Scanner(System.in);
            System.out.print("Confirm Password : ");
            String confPass = input3.nextLine();
            if (!UserNPassN.get(CurrentUsername).equals(confPass)) {
                System.out.println("!!Access Denied.!!");
                ATMMenu(CurrentUsername);
            }
            System.out.println("""
                                       -----------------------------------------------
                                       ////Withdraw////
                                       Account Citizen ID : """ + getId());
            System.out.println("""
                                   Select Menu 
                                -----------------------------------------------
                                1. Withdraw Bath
                                2. Withdraw Bitcoin """);

            System.out.print("Choose : ");
            int menuNO = input3.nextInt();
            switch (menuNO) {
                case 1:
                    System.out.print("Enter Amount (Baht) : ");

                    float newBalance = input3.nextFloat();

                    if (newBalance % 100 == 0) {
                        if (newBalance > Balance.get(CurrentUserID)) {
                            System.out.println("""
                                           -----------------------------------------------
                                           !!Insufficient Funds!!
                                           -----------------------------------------------""");
                            ATMMenu(CurrentUsername);
                        } else {
                            ArrayList<Integer> bank = new ArrayList<>();
                            bank.add(0, (int) newBalance / 1000);
                            if (bank.get(0) - Banknote.get(0) <= 0 || newBalance % 1000 != 0) {
                                bank.add(1, (int) newBalance / 500);
                                if (bank.get(1) - Banknote.get(1) <= 0 || newBalance % 500 != 0) {
                                    bank.add(0, (int) newBalance / 100);
                                    if (Banknote.get(0) <= 0 && Banknote.get(1) <= 0 && Banknote.get(2) <= 0) {
                                        System.out.println("""
                                           -----------------------------------------------
                                           !!Banknote is Empty!!
                                           -----------------------------------------------""");
                                        break;
                                    }
                                }

                            }

                            float balance = Balance.get(CurrentUserID) - ((bank.get(0) * 100) + (bank.get(1) * 500) + (bank.get(2) * 1000));
                            Balance.put(CurrentUserID, balance);
                            setBalance(balance);
                            System.out.println("-----------------------------------------------\n");
                            System.out.println("Plaese Recieve Banknote :\n100 Baht = " + bank.get(0) + " Banknote\n500 Baht = " + bank.get(1) + "Banknote\n1000 Baht = " + bank.get(2));
                            System.out.println("Your Balance is '" + Balance.get(CurrentUserID) + "'");
                            System.out.println("-----------------------------------------------\n");

                        }
                        break;
                    } else {
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Can not Release Banknote!!
                                           -----------------------------------------------""");
                        continue;
                    }

                case 2:
                    System.out.print("Enter Amount (Baht) : ");

                    newBalance = input3.nextFloat();
                    if (newBalance % 100 == 0) {
                        if (newBalance > getBalance()) {
                            System.out.println("""
                                           -----------------------------------------------
                                           !!Insufficient Funds!!
                                           -----------------------------------------------""");
                            ATMMenu(CurrentUsername);
                        } else {
                            ArrayList<Integer> bank = new ArrayList<>();
                            bank.add(0, (int) newBalance / 1000);
                            if (bank.get(0) - Banknote.get(0) <= 0 || newBalance % 1000 != 0) {
                                bank.add(1, (int) newBalance / 500);
                                if (bank.get(1) - Banknote.get(1) <= 0 || newBalance % 500 != 0) {
                                    bank.add(0, (int) newBalance / 100);
                                    if (Banknote.get(0) <= 0 && Banknote.get(1) <= 0 && Banknote.get(2) <= 0) {
                                        System.out.println("""
                                           -----------------------------------------------
                                           !!Banknote is Empty!!
                                           -----------------------------------------------""");
                                        break;
                                    }
                                }

                            }
                            float newBTC = Balance.get(CurrentUserID) - ((bank.get(0) * 100) + (bank.get(1) * 500) + (bank.get(2) * 1000));
                            BTC.put(CurrentUserID, newBTC/getBtcCurrency());
                            System.out.println("-----------------------------------------------\n");
                            System.out.println("Plaese Recieve Banknote :\n100 Baht = " + bank.get(0) + " Banknote\n500 Baht = " + bank.get(1) + "Banknote\n1000 Baht = " + bank.get(2));
                            System.out.println("Your Bitcoin is '" + BTC.get(CurrentUserID) + "'");
                            System.out.println("-----------------------------------------------\n");

                        }
                        break;
                    } else {
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Can not Release Banknote!!
                                           -----------------------------------------------""");
                        continue;
                    }
            }
            break;

        }

    }

    public void Deposit(String CurrentUsername, String CurrentUserID) {
        System.out.println("""
                           -----------------------------------------------
                           ATM Computer Thanyaburi Bank
                           -----------------------------------------------""");
        while (true) {
            Scanner input3 = new Scanner(System.in);
            System.out.print("Confirm Password : ");
            String confPass = input3.nextLine();
            if (!UserNPassN.get(CurrentUsername).equals(confPass)) {
                System.out.println("!!Access Denied.!!");
                System.out.println("-----------------------------------------------\n");
                ATMMenu(CurrentUsername);
            }
            System.out.println("""
                                       -----------------------------------------------
                                       ////Deposite////
                                       Account Citizen ID : """ + getId());
            System.out.println("""
                                   Select Menu  
                                -----------------------------------------------
                                1. Deposit Money
                                2. Thai Baht Convert to Bitcoin
                                3. Bitcoin Convert to Thai Baht""");

            System.out.print("Choose : ");
            int menuNO = input3.nextInt();
            switch (menuNO) {
                case 1:
                    System.out.print("""
                             -----------------------------------------------
                             Please Insert Banknote 
                             -----------------------------------------------
                             """);
                    System.out.print("100 Bath Amount = ");
                    int hundred = input3.nextInt();
                    System.out.print("500 Bath Amount = ");
                    int Fivehundred = input3.nextInt();
                    System.out.print("1000 Bath Amount = ");
                    int Thousan = input3.nextInt();
                    Banknote.add(0, hundred);
                    Banknote.add(1, Fivehundred);
                    Banknote.add(2, Thousan);

                    float newBalance = (100 * hundred) + (500 * Fivehundred) + (1000 * Thousan);
                    float balance = Balance.get(CurrentUserID) + newBalance;
                    if (balance > 1000000) {
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Over Limit!!
                                           -----------------------------------------------""");
                        ATMMenu(CurrentUsername);
                    } else {
                        Balance.put(CurrentUserID, balance);
                        System.out.println("-----------------------------------------------\n");
                        System.out.println("Your Balance is '" + Balance.get(CurrentUserID) + "'");
                        System.out.println("-----------------------------------------------\n");

                    }
                    break;
                case 2:
                    System.out.print("Your Bitcoin = "+Balance.get(CurrentUserID));
                    System.out.print("Enter Bitcoin Amount (BTC): ");
                    float newBTC = input3.nextFloat();
                    float money = Balance.get(CurrentUserID) - (newBTC * getBtcCurrency());
                    float btc = BTC.get(CurrentUserID) + newBTC;
                    if (money < 0) {
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Insufficient Funds!!
                                           -----------------------------------------------""");
                        break;
                    }

                    if (btc * btcCurrency > 1000000) {
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Over Limit!!
                                           -----------------------------------------------""");
                        break;
                    } else {

                        BTC.put(CurrentUserID, btc);
                        Balance.put(CurrentUserID, money);
                        setBtc(btc);
                        setBalance(money);
                        System.out.println("-----------------------------------------------\n");
                        System.out.println("Your Balance is '" + Balance.get(CurrentUserID) + "'\nand Bitcoin is '" + BTC.get(CurrentUserID) + "'");
                        System.out.println("-----------------------------------------------\n");

                    }
                    break;
                    case 3:
                     System.out.print("Your Bitcoin = "+Balance.get(CurrentUserID));
                    System.out.print("Enter Bitcoin Amount (BTC): ");
                     float newBTC2 = input3.nextFloat();
                     money = Balance.get(CurrentUserID) + (newBTC2 * getBtcCurrency());
                     btc = BTC.get(CurrentUserID) - newBTC2;
                    if (money < 0) {
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Insufficient Funds!!
                                           -----------------------------------------------""");
                        break;
                    }

                    if (btc * btcCurrency > 1000000) {
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Over Limit!!
                                           -----------------------------------------------""");
                        break;
                    } else {

                        BTC.put(CurrentUserID, btc);
                        Balance.put(CurrentUserID, money);
                        setBtc(btc);
                        setBalance(money);
                        System.out.println("-----------------------------------------------\n");
                        System.out.println("Your Balance is '" + Balance.get(CurrentUserID) + "'\nand Bitcoin is '" + BTC.get(CurrentUserID) + "'");
                        System.out.println("-----------------------------------------------\n");

                    }
                    break;
            }
            break;
        }

    }

    public void Transfer(String CurrentUsername, String CurrentUserID) {
        System.out.println("""
                           -----------------------------------------------
                           ATM Computer Thanyaburi Bank
                           -----------------------------------------------""");
        while (true) {
            Scanner input3 = new Scanner(System.in);
            System.out.print("Confirm Password : ");
            String confPass = input3.nextLine();
            if (!UserNPassN.get(CurrentUsername).equals(confPass)) {
                System.out.println("!!Access Denied.!!");
                System.out.println("-----------------------------------------------\n");
                ATMMenu(CurrentUsername);
            }
            System.out.println("""
                                       -----------------------------------------------
                                       ////Transfer////
                                       Account Citizen ID : """ + CurrentUserID);
            System.out.print("Enter Destination Account Citizen ID : ");
            String destiAc = input3.nextLine();
            if (Name.get(destiAc) == null || destiAc.length() != 13) {
                System.out.println("""
                                          -----------------------------------------------
                                          ID Doesn't Exist.
                                          ----------------------------------------------- """);

                break;
            }
            System.out.print("Destination Account Citizen Name : " + Name.get(destiAc) + "\n");
            System.out.println("""
                                   Select Currency 
                                -----------------------------------------------
                                1. Bath
                                2. Bitcoin """);

            System.out.print("Choose : ");
            int menuNO = input3.nextInt();
            switch (menuNO) {
                case 1:
                    System.out.print("Enter Money Amount : ");
                    float newBalance = input3.nextFloat();
                    float balance = Balance.get(CurrentUserID) - newBalance;
                    if (balance < 0) {
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Insufficient Funds!!
                                           -----------------------------------------------""");
                        ATMMenu(CurrentUsername);
                    }
                    float desBalance = Balance.get(destiAc) + newBalance;
                    if (desBalance > 1000000) {
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Over Limit!!
                                           -----------------------------------------------""");
                        ATMMenu(CurrentUsername);
                    } else {
                        Balance.put(CurrentUserID, balance);
                        Balance.put(destiAc, desBalance);
                        setBalance(balance);
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Transfer to '""" + Name.get(destiAc) + "' is Complete!!");
                        System.out.println("Your Balance is '" + Balance.get(CurrentUserID) + "'");
                        System.out.println("-----------------------------------------------\n");

                    }
                    break;
                case 2:
                    System.out.print("Enter Bitcoin Amount : ");
                    float newBTC = input3.nextFloat();
                    float btc = BTC.get(CurrentUserID) - newBTC;
                    if (btc < 0) {
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Insufficient Funds!!
                                           -----------------------------------------------""");
                        ATMMenu(CurrentUsername);
                    }
                    float desBTC = BTC.get(destiAc) + newBTC;
                    if (btc * btcCurrency > 1000000) {
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Over Limit!!
                                           -----------------------------------------------""");
                        ATMMenu(CurrentUsername);
                    } else {
                        BTC.put(CurrentUserID, btc);
                        BTC.put(destiAc, desBTC);
                        setBtc(btc);
                        System.out.println("""
                                           -----------------------------------------------
                                           !!Transfer to '""" + Name.get(destiAc) + "' is Complete!!");
                        System.out.println("Your Bitcoin is '" + BTC.get(CurrentUserID) + "'");
                        System.out.println("-----------------------------------------------\n");

                    }

                    break;
            }
            break;
        }

    }

}

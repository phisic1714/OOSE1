/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmuttatm3;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author phisic1714
 */
public class Account extends Person {
    
    HashSet<String> checkUsername= new HashSet<String>();
    
    public void accountInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Account Username= ");
        String username = input.nextLine();
            
            for (String i : checkUsername) {
                while (username.equals(i)) {
                    
                    System.out.print("""
                              !!This Username Already Exist!!
                              Account Username=  """);
                    
                    username = input.nextLine();
                } 
                
            }
        
        System.out.print("Account Password(4 Digit)= ");
        String password = input.nextLine();
        while (password.length() != 4) {
            System.out.print("""
                             !!You must Enter Account Password 4 Digit!!
                             Account Password(4 Digit)=  """);
            password = input.nextLine();
        }
        
        System.out.print("Balance(Limit at 1 Million Baht)= ");
        int balance = input.nextInt();
        while (balance > 1000000) {
            System.out.print("""
                             !!You must Enter Balance less than 1 Million Baht!!
                             Balance(Limit at 1 Million Baht)=  """);
            balance = input.nextInt();
        }
        System.out.print("Bitcoin (Limit at "+1000000/getBtcCurrency()+" BTC)= ");
        float btc = input.nextFloat();
        while (btc*getBtcCurrency() > 1000000) {
            System.out.print("!!You must Enter Bitcoin less than "+1000000/getBtcCurrency()+" BTC!!\nBalance(Limit at 1 Million Baht)= ");
                             
            btc = input.nextFloat();
        }
        
        setUsername(username);
        setPassword(password);
        setBalance(balance);
        setBtc(btc);
        UserNPassN.put(getUsername(), getPassword());
        ID.put(UserNPassN.get(getUsername()), getId());
        Balance.put(ID.get(UserNPassN.get(username)), getBalance());
        BTC.put(ID.get(UserNPassN.get(username)), getBtc());
        
    }
    
}

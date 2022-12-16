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
public class Account  extends Person {
    
   
     public void accountInput(){
     Scanner input = new Scanner(System.in);
        System.out.print("Account Username= ");
        String username = input.nextLine();
       

        System.out.print("Account Password(4 Digit)= ");
        String password = input.nextLine();
        while (password.length() != 4) {
            System.out.print("""
                             !!You must Enter Account Password 4 Digit!!
                             Account Password(4 Digit)= """);
            password = input.nextLine();
        }
 System.out.print("Balance(Limit at 1 Million Baht)= ");
        int balance = input.nextInt();
        while (balance > 1000000) {
            System.out.print("""
                             !!You must Enter Balance less than 1 Million Baht!!
                             Balance(Limit at 1 Million Baht)= """);
            balance = input.nextInt();
        }
        
        setUsername(username);
        setPassword(password);
         setBalance(balance);
     }

  
   
}

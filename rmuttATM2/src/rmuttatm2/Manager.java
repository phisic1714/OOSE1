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
  
   
     public void managerInput(){
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
}

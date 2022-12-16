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
public class Person extends bankSys {

    public void register() {
        Scanner input = new Scanner(System.in);
        System.out.print("Citizen ID(13 Digit)= ");
        String id = input.nextLine();
        while (id.length() != 13) {
            System.out.print("""
                             !!You must Enter Citizen ID 13 Digit!!
                             Account ID(13 Digit)= """);
            id = input.nextLine();
        }
        System.out.print("Name(less than 50 Digit)= ");
        String name = input.nextLine();
        while (name.length() > 50) {
            System.out.print("""
                             !!You must Enter Account Name less than 50 Digit!!
                             Account Name(less than 50 Digit)= """);
            name = input.nextLine();
        }

        System.out.print("Sex (F/M/L)= ");
        String sex = input.nextLine();
        switch (sex.toUpperCase()) {
            case "F":
                sex = "Female";
                break;
            case "M":
                sex = "Male";
                break;
            case "L":
                sex = "LGBTQIA+";
                break;
            default:
                sex = "None";
                break;
        }

        setId(id);
        setName(name);
        setSex(sex);
    }

}

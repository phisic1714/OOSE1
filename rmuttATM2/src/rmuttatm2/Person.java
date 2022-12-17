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
                             Citizen ID(13 Digit)= """);
            id = input.nextLine();
        }
        System.out.print("Name(less than 50 Digit)= ");
        String name = input.nextLine();
        while (name.length() > 50) {
            System.out.print("""
                             !!You must Enter Name less than 50 Digit!!
                             Name(less than 50 Digit)= """);
            name = input.nextLine();
        }

        System.out.print("Sex ('F' is Female/'M' is Male/'L' or other is LGBTQIA+)= ");
        String sex = input.nextLine();
        switch (sex.toUpperCase()) {
            case "F":
                sex = "Female";
                break;
            case "M":
                sex = "Male";
                break;
            case "":
                sex = "None";
                break;
            default:
                sex = "LGBTQIA+";
                break;
        }

        setId(id);
        setName(name);
        setSex(sex);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmuttatm3;

/**
 *
 * @author phisic1714
 */
public interface ATMActionable {

    public void Check(String CurrentUsername, String CurrentUserID);

    public void Withdraw(String CurrentUsername, String CurrentUserID);

    public void Deposit(String CurrentUsername, String CurrentUserID);

    public void Transfer(String CurrentUsername, String CurrentUserID);
}

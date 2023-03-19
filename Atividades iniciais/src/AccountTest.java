// CRIA E MANIPULA UM OBJETO ACCOUNT

import java.util.Scanner;

public class AccountTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // cria um objeto Account e o atribui a myAccount
        Account myAccount = new Account();

        System.out.printf("Inicial name is: %s%n", myAccount.getName());

        System.out.println("Enter the name: ");
        String theName = input.nextLine();
        myAccount.setName(theName);

        System.out.println();

        System.out.printf("Name in object myAccount is: %s%n", myAccount.getName());
    }
}

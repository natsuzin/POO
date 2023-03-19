// EXMEPLO DE ENTRADA E SAÍDA DE DADOS

import java.util.Scanner;

public class Addition
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1, num2, sum;

        System.out.print("First number: ");
        num1 = input.nextInt();

        System.out.print("Second number: ");
        num2 = input.nextInt();

        sum = num1 + num2;

        System.out.printf("Sum is %d", sum);
    }
}


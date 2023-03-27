package Ex1;

import Ex1.Ingresso;

public class IngressoTest
{
    public static void main(String[] args)
    {
        Ingresso i = new Ingresso();
        i.setValor(100.00F);

        IngressoVIP iv = new IngressoVIP();
        iv.setValorAdicional(50.00F);

        System.out.printf(i.toString());
        System.out.printf(iv.toString());
    }
}
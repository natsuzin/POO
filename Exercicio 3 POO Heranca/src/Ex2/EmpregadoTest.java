package Ex2;

public class EmpregadoTest 
{
    public static void main (String[] args){

        Gerente g = new Gerente("Maria", 2000.00F, "RH");
        Vendedor v = new Vendedor("João", 1500.00F, 50);

        System.out.println(g.toString());
        System.out.println(v.toString());
    }
}

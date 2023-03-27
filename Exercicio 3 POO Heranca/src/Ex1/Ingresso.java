package Ex1;

public class Ingresso
{
    private float valor;

    public Ingresso()
    {
        this.valor = 0;
    }

    public Ingresso(float valor)
    {
        this.valor = valor;
    }

    public void setValor(float  valor)
    {
        this.valor = valor;
    }

    public float getValor()
    {
        return valor;
    }

    @Override
    public String toString()
    {
        return String.format("Valor: %.2f\n", getValor());
    }
}
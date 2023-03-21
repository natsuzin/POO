package Ex1;

import Ex1.Ingresso;

public class IngressoVIP extends Ingresso
{
    private float valorAdicional;

    public IngressoVIP()
    {
        super();
        valorAdicional = 0;
    }

    public IngressoVIP(float valor, float valorAdicional)
    {
        super(valor);
        this.valorAdicional = valorAdicional;
    }

    public void setValorAdicional(float valorAdicional)
    {
        this.valorAdicional = valorAdicional;
    }

    public float getValorAdicional()
    {
        return valorAdicional;
    }

    @Override
    public String toString()
    {
        return String.format("Valor: %.2f - Valor adicional: %.2f\n", getValor(), getValorAdicional());
    }
}

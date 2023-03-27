package Ex2;

public class Gerente extends Empregado
{
    private String departamento;

    public Gerente()
    {
        super();
        departamento =  "";
    }

    public Gerente(String nome, float salario, String departamento)
    {
        super(nome, salario);
        this.departamento = departamento;
    }

    public void setDepartamento(String departamento)
    {
        this.departamento = departamento;
    }

    public String getDepartamento()
    {
        return departamento;
    }

    @Override
    public String toString()
    {
        return String.format(super.toString() + " - Departamento: %s", getDepartamento());
    }
}

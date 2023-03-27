package Ex2;

public class Empregado
{
    private String nome;
    private float salario;

    public Empregado()
    {
        nome = "";
        this.salario = 0;
    }

    public Empregado(String nome, float salario)
    {
        this.nome = nome;
        this.salario = salario;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setSalario(float salario)
    {
        this.salario = salario;
    }

    public float getSalario()
    {
        return salario;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s\n Salário: %f\n", getNome(), getSalario());
    }
}
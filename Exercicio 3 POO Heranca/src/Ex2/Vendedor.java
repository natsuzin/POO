package Ex2;

public class Vendedor extends Empregado
{
  private float percentualComissao;
  
  public Empregado()
  {
    super();
    percentualComissao = 0;
  }
  
  public Empregado(String nome, float salario, float percentualComissao)
  {
    super(nome, salario);
    this.percentualComissao = percentualComissao;
  }
  
  public void setPercentualComissao(float percentualComissao)
  {
    this.percentualComissao = percentualComissao;
  }
  
  public float getPercentualComissao()
  {
    return percentualComissao;
  }
  
  public float calcularSalario()
  {
    return super.getSalario() + (super.getSalario() * (getPercentualComisao() / 100));
  }
  
  @Override
  public String toString()
  {
  return String.format(super.toString() + " - Percentual: %.2f - Salário com comissão: %.2f%n", getPercentualComisao()/100, calcularSalario());
  }
}

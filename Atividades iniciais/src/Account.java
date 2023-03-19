public class Account
{
    private String name; // variável de instância (atributo provado)

    // método para definir o nome no objeto
    public void setName(String name) // método público
    {
        this.name = name;
    }

    // método para recuperar o nome do objeto
    public String getName() // método público
    {
        return name;
    }
}

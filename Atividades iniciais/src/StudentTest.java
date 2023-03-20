// CRIA E TESTA OBJETOS STUDENT

public class StudentTest
{
    public static void main(String[] args)
    {
        Student account1 = new Student("Maria", 90.5);
        Student account2 = new Student("John", 45.7);
        Student account3 = new Student("Ana", 78.25);

        System.out.printf("%s's letter grade is: %s\n", account1.getName(), account1.getLetterGrade());
        System.out.printf("%s's letter grade is: %s\n", account2.getName(), account2.getLetterGrade());
        System.out.printf("%s's letter grade is: %s\n", account3.getName(), account3.getLetterGrade());
    }
}

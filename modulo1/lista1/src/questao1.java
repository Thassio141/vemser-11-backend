import java.util.Scanner;
public class questao1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual é o seu nome? ");
        String nome = sc.next();
        System.out.println("Qual a sua idade? ");
        int idade = sc.nextInt();
        System.out.println("Qual a cidade que você mora? ");
        String cidade = sc.next();
        System.out.println("Qual o estado que você mora? ");
        String estado = sc.next();
        System.out.println("Olá seu nome é " + nome + ", você tem " + idade + " anos, é da cidade de " + cidade + ", situada no estado de " + estado );
    }
}
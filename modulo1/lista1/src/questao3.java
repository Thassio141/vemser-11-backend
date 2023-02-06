import java.util.Scanner;
public class questao3   {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Palavra que você quer traduzir (obs: escrever tudo minusculo porfavor): ");
        String palavra = sc.next();

        switch (palavra) {
            case "cachorro" -> System.out.println("Tradução : dog ");
            case "tempo" -> System.out.println("Tradução : time");
            case "amor" -> System.out.println("Tradução : love");
            case "cidade" -> System.out.println("Tradução : city");
            case "feliz" -> System.out.println("Tradução : happy");
            case "triste" -> System.out.println("Tradução : sad");
            case "deveria" -> System.out.println("Tradução : should ");
            case "poderia" -> System.out.println("Tradução : could");
            case "dog" -> System.out.println("Tradução : cachorro");
            case "time" -> System.out.println("Tradução : tempo");
            case "love" -> System.out.println("Tradução : amor");
            case "city" -> System.out.println("Tradução : cidade");
            case "happy" -> System.out.println("Tradução : feliz");
            case "sad" -> System.out.println("Tradução : triste");
            case "should" -> System.out.println("Tradução : deveria");
            case "could" -> System.out.println("Tradução : poderia");
            default -> System.out.println("Essa palavra não é válida.");
        }
    }
}

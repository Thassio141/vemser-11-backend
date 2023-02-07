import java.util.Scanner;
public class Questao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, chute;

        System.out.println("Forneça um numero para que outra pessoa tente adivinhar: ");
        numero = sc.nextInt();

        while (true) {
            System.out.println("Tente adivinhar o numero: ");
            chute = sc.nextInt();

            if (chute == numero) {
                System.out.println("Você Acertou!");
                break;
            } else if (chute > numero) {
                System.out.println("O numero é menor que " + chute);
            } else {
                System.out.println("O numero é maior que " + chute);
            }

        }
    }
}

import java.util.Scanner;
public class questao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero , chute;

        System.out.println("Forneça um numero para que outra pessoa tente adivinhar: ");
        numero = sc.nextInt();

        System.out.println("Tente adivinhar o numero: ");
        chute = sc.nextInt();

        if ( chute == numero) {
            System.out.println("Você Acertou!");
        }
        else{
            while (chute != numero){
                System.out.println("Tente adivinhar o numero: ");
                chute = sc.nextInt();
                if ( chute == numero) {
                    System.out.println("Você Acertou!");
                }

            }
        }

    }
}

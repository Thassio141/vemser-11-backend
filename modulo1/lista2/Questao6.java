import java.util.Scanner;
public class Questao6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = {1,9,3,4,2,6,7,8,9,10};
        int contador = 0, numMenor = 0, numMaior = 0;
        int num ;

        System.out.println("Digite um numero: ");
        num = sc.nextInt();

        for (int x = 0; x < vetor.length; x ++){
            if (num == vetor[x]){
                contador += 1;
            }
            else if (num > vetor[x] ){
                numMenor += 1;
            }
            else {
                numMaior += 1;
            }
        }
        System.out.println("O numero fornecido foi: " + num + "\n" +
                "Quantidade de vezes que o numero apareceu no vetor: " + contador + "\n" +
                "Quantidade de numeros menor que " + num + " foi de " + numMenor + "\n" +
                "Quantidade de numeros maiores que " + num + " foi de " + numMaior );
    }
}

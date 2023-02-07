
import java.util.Scanner;
public class Questao3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome, nomeMaiorJogador = null, nomeMaisVelho = null, nomeMaisPesado = null;
        int idade, maisVelho = 0;
        int contador = 0;
        double altura , peso, mediaAltura = 0, alturaMaiorJogador = 0, maisPesado = 0;

        while (true){
            System.out.println("Nome do Jogador: ");
            nome = sc.next();
            if (nome.equals("sair")){
                break;
            }
            else{
                contador += 1;
                System.out.println("Idade do Jogador: ");
                idade = sc.nextInt();

                if (idade > maisVelho){
                    maisVelho = idade;
                    nomeMaisVelho = nome;
                }

                System.out.println("Altura do Jogador: ");
                altura = sc.nextDouble();

                if (altura > alturaMaiorJogador ){
                    alturaMaiorJogador = altura;
                    nomeMaiorJogador = nome;
                }

                System.out.println("Peso do Jogador: ");
                peso = sc.nextDouble();

                if (peso > maisPesado){
                    maisPesado = peso;
                    nomeMaisPesado = nome;
                }
                mediaAltura += altura;

            }
        }
        mediaAltura = mediaAltura/contador;
        System.out.println("Quantidade de jogadores cadastrados: " + contador + "\n" +
                nomeMaiorJogador + " é o mais alto tendo " + alturaMaiorJogador + "m\n" +
                "Jogador mais velho: " + nomeMaisVelho + " com a idade de " + maisVelho + "\n" +
                "Jogador mais pesado: " + nomeMaisPesado + " com " + maisPesado + "kg\n" +
                "Media das alturas dos jogadores: " + mediaAltura);
    }
}

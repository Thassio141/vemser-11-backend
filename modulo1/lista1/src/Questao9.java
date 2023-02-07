import java.util.Scanner;
public class Questao9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int horaInicial, minutoInicial, horaFinal, minutoFinal, duracaoJogoHoras, duracaoJogoMinutos;

        System.out.println("Hora do inicio do jogo: ");
        horaInicial = sc.nextInt();

        System.out.println("Minutos do inicio do jogo: ");
        minutoInicial = sc.nextInt();

        System.out.println("Hora final do jogo: ");
        horaFinal = sc.nextInt();

        System.out.println("Minuto final do jogo: ");
        minutoFinal = sc.nextInt();

        if (horaInicial > horaFinal){
            duracaoJogoHoras = horaFinal - horaInicial + 24;

            if ( minutoInicial > minutoFinal){
                duracaoJogoHoras = duracaoJogoHoras - 1;
                duracaoJogoMinutos = minutoFinal - minutoInicial + 60;
                System.out.println("A duração do jogo foi de " + duracaoJogoHoras + "hr" + duracaoJogoMinutos + "min");
            }
            else{
                duracaoJogoMinutos = minutoFinal - minutoInicial;
                System.out.println("A duração do jogo foi de " + duracaoJogoHoras + "hr" + duracaoJogoMinutos + "min");
            }

        }
        else {
            duracaoJogoHoras = horaFinal - horaInicial;
            if ( minutoInicial > minutoFinal){
                duracaoJogoHoras = duracaoJogoHoras - 1;
                duracaoJogoMinutos = minutoFinal - minutoInicial + 60;
                System.out.println("A duração do jogo foi de " + duracaoJogoHoras + "hr" + duracaoJogoMinutos + "min");
            }
            else{
                duracaoJogoMinutos = minutoFinal - minutoInicial;
                System.out.println("A duração do jogo foi de " + duracaoJogoHoras + "hr" + duracaoJogoMinutos + "min");
            }
        }
    }
}

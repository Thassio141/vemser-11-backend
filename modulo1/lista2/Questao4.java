import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        double[][] matriz = new double[4][5];
        Scanner sc = new Scanner(System.in);
        double mediaNotasFinais, maiorNotaFinal = 0;
        int matricula = 0;

        //3 primeiras informações dos alunos
        for (int x = 0; x < 5; x++) {
            System.out.println("Digite respectivamente com a matricula, media das provas e a media dos trabalhos do aluno: ");
            for (int y = 0; y < 3; y++) {
                matriz[y][x] = sc.nextInt();
                System.out.println(matriz[y][x]);
            }
        }
        //calcule a nota final
        for (int x = 0; x < 5; x++){
            matriz[3][x] = matriz[1][x] * 0.6 + matriz[2][x] * 0.4;

            if (matriz[3][x] > maiorNotaFinal){
                maiorNotaFinal = matriz[3][x];
                matricula = (int) matriz[0][x];
            }
        }

        //Imprima a matrícula que obteve a maior nota fina
        System.out.println("maior nota final" + maiorNotaFinal + " foi da matricula " + matricula);

        //Imprima a média das notas finais
        mediaNotasFinais = (matriz[3][0] + matriz[3][1]+ matriz[3][2]+ matriz[3][3]+ matriz[3][4])/5;
        System.out.println("Medias das Notas Finais: " + mediaNotasFinais);
    }
}

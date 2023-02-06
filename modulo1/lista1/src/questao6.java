import java.util.Scanner;

public class questao6 {
    public static void main(String[] args) {
        int eleitores, votos_brancos, nulos , validos;
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantidade de eleitores do municipio: ");
        eleitores = sc.nextInt();

        System.out.println("Quantidade de votos brancos: ");
        votos_brancos = sc.nextInt();

        System.out.println("Quantidade de votos nulos: ");
        nulos = sc.nextInt();

        System.out.println("Quantidade de votos validos: ");
        validos = sc.nextInt();

        votos_brancos = (votos_brancos * 100) / eleitores ;

        nulos = (nulos * 100) / eleitores;

        validos = (validos * 100) / eleitores;

        System.out.println("Percentual de votos brancos: " + votos_brancos + "%" + ", nulos: " + nulos + "%" + ", validos: " + validos + "%");
    }
}

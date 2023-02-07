import java.util.Scanner;
public class questao1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String produto;
        double valor, valorFinal;
        double [] lista = new double[11];

        System.out.println("Nome do Produto: ");
        produto = sc.nextLine();

        System.out.println("Valor do Produto: ");
        valor = sc.nextDouble();

        System.out.println("Produto: " + produto + "\n" +
                "Preço: " + valor + "\n" +
                "Promoção: " + produto + "\n" +
                "--------------------------------");
        for (int x = 1; x < lista.length; x ++){
            lista[x] = valor - (valor * (5*x)/100);
            valorFinal = lista[x] * x;
            System.out.println(x + " x " + "R$ " + lista[x] + " = R$ " + valorFinal);
        }

    }
}

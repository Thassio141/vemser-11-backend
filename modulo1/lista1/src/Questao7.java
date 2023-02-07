import java.util.Scanner;
public class Questao7 {
    public static void main(String[] args) {
        String codigo;
        int qtd;
        double valor;

        Scanner sc = new Scanner(System.in);

        System.out.println("Codigo do produto (escrever tudo em maisculo): ");
        codigo = sc.nextLine();

        switch (codigo){
            case "ABCD":
                System.out.println("Quantidade comprada: ");
                qtd = sc.nextInt();
                valor = 5.30 * qtd;
                System.out.println("Preço total devido: " + valor);
                break;

            case "XYPK":
                System.out.println("Quantidade comprada: ");
                qtd = sc.nextInt();
                valor = 6 * qtd;
                System.out.println("Preço total devido: " + valor);
                break;

            case "KLMP":
                System.out.println("Quantidade comprada: ");
                qtd = sc.nextInt();
                valor = 3.20 * qtd;
                System.out.println("Preço total devido: " + valor);
                break;

            case "QRST":
                System.out.println("Quantidade comprada: ");
                qtd = sc.nextInt();
                valor = 2.50 * qtd;
                System.out.println("Preço total devido: " + valor);
                break;

            default:
                System.out.println("Codigo invalido");
                break;
        }
    }
}

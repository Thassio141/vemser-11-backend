import java.util.Scanner;
public class questao4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a ,b,c;

        System.out.println("Valor da variavel A: ");
        a = sc.nextInt();

        System.out.println("Valor da variavel B: ");
        b = sc.nextInt();

        c = a;
        a = b;
        b = c;

        System.out.println("Variavel A: "+ a + " , Variavel B: " + b);

    }
}

import java.util.Scanner;
public class Questao4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 10;
        int b = 20;
        int c;

        c = a;
        a = b;
        b = c;

        System.out.println("Variavel A: "+ a + " , Variavel B: " + b);

    }
}

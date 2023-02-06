import java.util.Scanner;
public class questao5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base , altura, area;

        System.out.print("Altura do retangulo: ");
        altura = sc.nextDouble();
        System.out.println("Base do retangulo: ");
        base = sc.nextDouble();

        area = base * altura;

        System.out.println("A área do retangulo é de: " + area);
    }
}

import java.util.Scanner;
public class Questao8 {
    public static void main(String[] args) {
        double salario , aumento, diferenca;
        String cargo;

        Scanner sc = new Scanner(System.in);
        System.out.println("Salario: ");
        salario = sc.nextDouble();

        System.out.println("""
                Digite o seu cargo (escrever em minusculo):
                Gerente     
                Engenheiro  
                Técnico     """);

        cargo = sc.next();

        switch (cargo){

            case "gerente":
                aumento = salario + (salario * 10/100);
                diferenca = aumento - salario;
                System.out.println("Salario antigo: "+salario+", novo salario: "+aumento+" e a diferença é de: "+ diferenca);
                break;

            case "engenheiro":
                aumento = salario + (salario * 20/100);
                diferenca = aumento - salario;
                System.out.println("Salario antigo: "+salario+", novo salario: "+aumento+" e a diferença é de: "+ diferenca);
                break;

            case "tecnico":
                aumento = salario + (salario * 30/100);
                diferenca = aumento - salario;
                System.out.println("Salario antigo: "+salario+", novo salario: "+aumento+" e a diferença é de: "+ diferenca);
                break;

            default:
                aumento = salario + (salario * 40/100);
                diferenca = aumento - salario;
                System.out.println("Salario antigo: "+salario+", novo salario: "+aumento+" e a diferença é de: "+ diferenca);
                break;

        }
    }
}

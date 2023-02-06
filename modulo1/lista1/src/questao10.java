import java.util.Scanner;
public class questao10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int identificacao;
        double nota1, nota2, nota3, me , ma;
        String conceito, resultado;

        System.out.println("Digite seu numero de identificação: ");
        identificacao = sc.nextInt();

        System.out.println("Digite a primeira nota: ");
        nota1 = sc.nextDouble();

        System.out.println("Digite a segunda nota: ");
        nota2 = sc.nextDouble();

        System.out.println("Digite a terceira nota: ");
        nota3 = sc.nextDouble();

        System.out.println("Media dos exercicios: ");
        me = sc.nextDouble();

        ma = (nota1 + nota2 * 2 + nota3 * 3 + me)/7;

        if (ma < 4 ){
            conceito = "E";
            resultado = "Reprovado";
            System.out.println("Numero de dentificação: "+identificacao+"\n" +
                    "Nota 1: "+nota1+"\n" +
                    "Nota 2: "+nota2+"\n" +
                    "Nota 3: "+nota3+"\n" +
                    "ME: " + me +"\n" +
                    "MA: " + ma +"\n" +
                    "Conceito: " + conceito + "\n" +
                    resultado);
        }

        else if ((ma >= 4) & (ma < 6)){
            conceito = "D";
            resultado = "Reprovado";
            System.out.println("Numero de dentificação: "+identificacao+"\n" +
                    "Nota 1: "+nota1+"\n" +
                    "Nota 2: "+nota2+"\n" +
                    "Nota 3: "+nota3+"\n" +
                    "ME: " + me +"\n" +
                    "MA: " + ma +"\n" +
                    "Conceito: " + conceito + "\n" +
                    resultado);
        }

        else if ((ma >= 6) & (ma < 7.5)){
            conceito = "C";
            resultado = "Aprovado";
            System.out.println("Numero de dentificação: "+identificacao+"\n" +
                    "Nota 1: "+nota1+"\n" +
                    "Nota 2: "+nota2+"\n" +
                    "Nota 3: "+nota3+"\n" +
                    "ME: " + me +"\n" +
                    "MA: " + ma +"\n" +
                    "Conceito: " + conceito + "\n" +
                    resultado);
        }

        else if ((ma >= 7.5) & (ma < 9)){
            conceito = "B";
            resultado = "Aprovado";
            System.out.println("Numero de dentificação: "+identificacao+"\n" +
                    "Nota 1: "+nota1+"\n" +
                    "Nota 2: "+nota2+"\n" +
                    "Nota 3: "+nota3+"\n" +
                    "ME: " + me +"\n" +
                    "MA: " + ma +"\n" +
                    "Conceito: " + conceito + "\n" +
                    resultado);
        }

        else if (ma >= 9){
            conceito = "A";
            resultado = "Aprovado";
            System.out.println("Numero de dentificação: "+identificacao+"\n" +
                    "Nota 1: "+nota1+"\n" +
                    "Nota 2: "+nota2+"\n" +
                    "Nota 3: "+nota3+"\n" +
                    "ME: " + me +"\n" +
                    "MA: " + ma +"\n" +
                    "Conceito: " + conceito + "\n" +
                    resultado);
        }
    }
}

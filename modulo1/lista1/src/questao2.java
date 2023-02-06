import java.util.Scanner;
public class questao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o numero correspondente ao estado desejado\n" +
                "Rio Grande do Sul - [1]\n" +
                "Bahia             - [2]\n" +
                "Rio de Janeiro    - [3]\n" +
                "opcão: ");
        int opcao = sc.nextInt();

        if ( opcao == 1 ){
            System.out.println("Digite o numero correspondente a cidade desejada\n" +
                    "Porto Alegre - [1]\n" +
                    "Gramado      - [2]\n" +
                    "opcao: ");
            opcao = sc.nextInt();

            if ( opcao == 1) {
                System.out.println("Porto Alegre tem 1.409.351 habitantes , 0,805 no IDH e uma das principais festas é a Festa de Navegantes.");
            }
            else if (opcao == 2){
                System.out.println("Gramado 36.555, IDH de 0.841 e uma das principais festas é Festuris (Festival de Turismo de Gramado).");
            }
            else{
                System.out.println("Essa opção não é valida");
            }
        }
        else if ( opcao == 2 ){
            System.out.println("Digite o numero correspondente a cidade desejada\n" +
                    "Salvador         - [1]\n" +
                    "Porto Seguro     - [2]\n" +
                    "opcao: ");
            opcao = sc.nextInt();

            if (opcao == 1){
                System.out.println("Salvador possui 2.886.698 habitantes, IDH 0,675 e uma das principais festas é a Festa de Santa Bárbara.");
            }

            else if (opcao == 2){
                System.out.println("Porto Seguro possui 150.658 habitantes, IDH 0,676 e uma das principais festas é a Arraial d'Ajuda.");
            }
            else{
                System.out.println("Essa opção não é valida");
            }

        }
        else if ( opcao == 3 ){
            System.out.println("Digite o numero correspondente a cidade desejada\n" +
                    "Rio de Janeiro         - [1]\n" +
                    "Cabo Frio              - [2]\n" +
                    "opcao: ");
            opcao = sc.nextInt();

            if (opcao == 1){
                System.out.println("Rio de Janeiro tem 6,738 milhões de habitantes , IDH de  0,832 e uma das principais festas é o Carnaval.");
            }
            else if ( opcao == 2){
                System.out.println("Cabo Frio tem 216.030 habitantes, IDH de 0,735 e uma das principais festas é a Festa da Padroeira de Cabo Frio - Nossa Senhora de Assunção.");
            }
            else{
                System.out.println("Essa opção não é valida");
            }
        }

        else{
            System.out.println("Essa opção não é valida");
        }
    }
}


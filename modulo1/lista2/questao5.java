public class questao5 {
    public static void main(String[] args) {
        //somar colunas
        double sum = 0, sum1 =0 , sum2 = 0;
        int idMercado = 0;
        double maisBarato = 0;
        double[][] matriz ={
                {1.0,1.0,1.0},
                {2.0,2.0,2.0},
                {3.0,3.0,3.0},
                {4.0,4.0,4.0},
                {5.0,5.0,5.0},
                {6.0,6.0,6.0},
                {7.0,7.0,7.0},
                {8.0,8.0,8.0},
                {9.0,9.0,9.0},
                {9.0,7.0,10.0},
        };

        for (int x = 0; x < 10; x++){
            sum += matriz[x][0];
        }
        for (int x = 0; x < 10; x++){
            sum1 += matriz[x][1];
        }
        for (int x = 0; x < 10; x++){
            sum2 += matriz[x][2];
        }

        if (sum < sum1 && sum < sum2){
            maisBarato = sum;
            idMercado = 1;
        }
        else if ( sum1 < sum2 && sum1 < sum){
            maisBarato = sum1;
            idMercado = 2;
        }
        else  {
            maisBarato = sum2;
            idMercado = 3;
        }

        System.out.println(sum);
        System.out.println(sum1);
        System.out.println(sum2);

        System.out.println("O mercado mais barato é o mercado: " + idMercado );
    }
}

public class Contato {

        String descricao , telefone;
        int tipo; // tipo == 1 : residencial , tipo == 2 : comercial

        public void imprimirContato(){
                if ( tipo == 1){
                        System.out.println("Descricao: " + descricao + " telefone " + telefone + ", tipo residencial");
                }
                else {
                        System.out.println("Descricao: " + descricao + " telefone " + telefone + ", tipo comercial");
                }
        }


}

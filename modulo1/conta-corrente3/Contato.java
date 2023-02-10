public class Contato {

        private String descricao , telefone;
        private int tipo; // tipo == 1 : residencial , tipo == 2 : comercial

        public void imprimirContato(){
                if ( tipo == 1){
                        System.out.println("Descricao: " + descricao + " telefone " + telefone + ", tipo residencial");
                }
                else {
                        System.out.println("Descricao: " + descricao + " telefone " + telefone + ", tipo comercial");
                }
        }

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public String getTelefone() {
                return telefone;
        }

        public void setTelefone(String telefone) {
                this.telefone = telefone;
        }

        public int getTipo() {
                return tipo;
        }

        public void setTipo(int tipo) {
                this.tipo = tipo;
        }

        public Contato(String descricao, String telefone, int tipo) {
                this.descricao = descricao;
                this.telefone = telefone;
                this.tipo = tipo;
        }
}

package br.com.dbc.vemser.pessoaapi.entity;

public enum TipoFilme {
 TERROR_SUSPENSE(0),
 ANIMACAO(1),
 DRAMA_MISTERIO(2),
 COMEDIA_ROMANCE(3);

 private Integer valor;

 TipoFilme(Integer valor){
  this.valor = valor;
 }
}

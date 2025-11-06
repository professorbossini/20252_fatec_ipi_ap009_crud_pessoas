package br.gov.sp.cps.fatecipiranga.model;

import lombok.Data;

@Data
public class Pessoa {
  private int codigo;
  private String nome;
  private String fone;
  private String email;

  public Pessoa(String nome, String fone, String email){
    this(0 , nome, fone, email);
  }

  public Pessoa(int codigo, String nome, String fone, String email){
    setCodigo(codigo);
    setNome(nome);
    setFone(fone);
    setEmail(email);
  }
}

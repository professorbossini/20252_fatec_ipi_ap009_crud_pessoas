package br.gov.sp.cps.fatecipiranga.model;

import lombok.Data;

@Data
public class Pessoa {
  private int codigo;
  private String nome;
  private String fone;
  private String email;
}

package br.gov.sp.cps.fatecipiranga.db;

import java.sql.PreparedStatement;

import br.gov.sp.cps.fatecipiranga.model.Pessoa;

//data access object
public class PessoaDAO {

  //JDBC: Java DataBase Connectivity
  public void cadastrar(Pessoa p) throws Exception{
    //1. Especificar o comando SQL
    var sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES(?, ?, ?)";
    //2. Obter uma conexão com o SGBD
    var conexao = ConnectionFactory.getConnection();
    //3. Preparar o comando
    PreparedStatement ps = conexao.prepareStatement(sql);
    //4. Substituir os eventuais placeholders
    ps.setString(1, p.getNome());
    ps.setString(2, p.getFone());
    ps.setString(3, p.getEmail());
    //5. Executar o comando
    ps.execute();
    //6. Fechar os recursos
    ps.close();
    conexao.close();
  } 

  public void atualizar(Pessoa p) throws Exception{
    //1. Especificar o comando SQL
    var sql = "UPDATE tb_pessoa SET nome=?, fone=?, email=? WHERE cod_pessoa=?";
    //2. Obter uma conexão com SGBD
    //Java 7+: try-with-resource
    //3. Preparar o comando
    try(
      var conexao = ConnectionFactory.getConnection();
      var ps = conexao.prepareStatement(sql);
    ){
      //4. Substituir os eventuais placeholders
      ps.setString(1, p.getNome());
      ps.setString(2, p.getFone());
      ps.setString(3, p.getEmail());
      ps.setInt(4, p.getCodigo());
      //5. Executar o comando
      ps.execute();
      //6. Fechar a conexão
      //já foi feito pelo try-with-resources
    }

  }
}

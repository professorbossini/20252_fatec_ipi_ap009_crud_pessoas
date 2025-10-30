package br.gov.sp.cps.fatecipiranga.db;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
  private static String host = "10.67.172.110";
  private static String port = "5432";
  private static String user = "postgres";
  private static String password = "postgres";
  private static String database = "20252_fatec_ipi_poo_bossini";

  static Connection getConnection(){
    try{
      //https://www.google.com:443/search
      String url = String.format(
        "jdbc:postgresql://%s:%s/%s",
        host, port, database
      );
      Connection conexao = DriverManager.getConnection(url, user, password);
      return conexao;
    }
    catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }  

  public static void main(String[] args) {
    Connection conexao = getConnection();
    if(conexao != null){
      System.out.println("Conectou!");
    }
    else{
      System.out.println("Não conectou!");
    }  
  }
}

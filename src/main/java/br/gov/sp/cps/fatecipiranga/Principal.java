package br.gov.sp.cps.fatecipiranga;

import javax.swing.JOptionPane;

import br.gov.sp.cps.fatecipiranga.db.PessoaDAO;
import br.gov.sp.cps.fatecipiranga.model.Pessoa;

public class Principal {
  public static void main(String[] args) {
    var menu = "1-Cadastrar\n2-Atualizar\n0-Sair\n";
    int op;
    do{
      do{
        op = Integer.parseInt(JOptionPane.showInputDialog(menu));
      }while(op < 0 || op > 4);
      switch(op){
        case 1:{
          try{
            var nome = JOptionPane.showInputDialog("Nome?");
            var fone = JOptionPane.showInputDialog("Fone?");
            var email = JOptionPane.showInputDialog("E-mail?");
            var pessoa = new Pessoa(nome, fone, email);
            var pessoaDAO = new PessoaDAO();
            pessoaDAO.cadastrar(pessoa);
            JOptionPane.showMessageDialog(null, "Pessoa cadastrada");
          }
          catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                null, 
                "Tente novamente mais tarde"
            );
          }
          break;
        }
        case 2:{
          try{
            var nome = JOptionPane.showInputDialog("Nome?");
            var fone = JOptionPane.showInputDialog("Fone?");
            var email = JOptionPane.showInputDialog("E-mail?");
            var codigo = Integer.parseInt(JOptionPane.showInputDialog("Código?"));
            var p = new Pessoa(codigo, nome, fone, email);
            var pessoaDAO = new PessoaDAO();
            pessoaDAO.atualizar(p);
            JOptionPane.showMessageDialog(null, "Pessoa atualizada");
          }
          catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Tente novamente mais tarde");
          }
          break;
        }
        case 0:{
          break;
        }
      }

    }while(op != 0);





  }
}

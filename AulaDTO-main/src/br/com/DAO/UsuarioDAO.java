
package br.com.DAO;

import br.com.DAO.ConexaoDAO;
import br.com.DTO.UsuarioDTO;
import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs= null;
    
    public void inserirUsuario(UsuarioDTO objUsuarioDTO){
        String sql ="insert into tb_usuarios(id_usuario, usuario, login, senha ) values(?,?,?,?)";
        conexao = new ConexaoDAO().conector();
        
        try {
            pst = conexao.prepareStatement(sql); 
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            pst.setString(2, objUsuarioDTO.getNomeUsuario());
            pst.setString(3, objUsuarioDTO.getLoginUsuario());
            pst.setString(4, objUsuarioDTO.getSenhaUsuario());
            
          int add = pst.executeUpdate();
          
          if (objUsuarioDTO.getId_usuario() < 0) {
            JOptionPane.showMessageDialog(null, "Erro: O ID do usuário não pode ser menor que 0.");
            return;
        }
          
           if (objUsuarioDTO.getNomeUsuario().isEmpty() || 
            objUsuarioDTO.getLoginUsuario().isEmpty() || 
            objUsuarioDTO.getSenhaUsuario().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Erro: Todos os campos devem ser preenchidos.");
            return;
        }
          
          if(add > 0){
          JOptionPane.showMessageDialog(null, "Inserido com sucesso");
          
          }else{
           JOptionPane.showMessageDialog(null, "Erro");
              
          }
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null," Inserir Usuario" + e);
        }
        
        
        
        
    }
}

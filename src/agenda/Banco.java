package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Danilo de Maria daniloctg@msn.com
 */
public class Banco {

    public static Connection Connect() {
        String url = "jdbc:postgresql://localhost:5432/agenda";
        String usuario = "agenda";
        String senha = "agenda";
        String driverName = "org.postgresql.Driver";

        Connection conn = null;
        try {
            Class.forName(driverName).newInstance();
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao tentar conectar com o banco de dados, contate o suporte");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao tentar conectar com o banco de dados, contate o suporte");
        }
        return conn;
    }

    public boolean cadastraCliente(Cliente a) {
        PreparedStatement pst;
        String stm = "INSERT INTO cliente (nome, telFixo, telCel, email) values(?, ?, ?, ?)";

        try {
            Connection conn = Banco.Connect();
            pst = conn.prepareStatement(stm);
            pst.setString(1, a.getNome());
            pst.setString(2, a.getTelefoneFixo());
            pst.setString(3, a.getTelefoneCelular());
            pst.setString(4, a.getEmail());
            pst.execute();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
            return false;
        }
        return true;
    }

    ResultSet preencheTabelaContato() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "SELECT * from cliente order by nome";

        try {
            Connection conn = Banco.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public ResultSet buscaContato(String text) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "SELECT * from cliente where nome ilike ? order by nome";
        try {
            Connection conn = Banco.Connect();
            pst = conn.prepareStatement(stm);
            pst.setString(1, "%" + text + "%");
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

}

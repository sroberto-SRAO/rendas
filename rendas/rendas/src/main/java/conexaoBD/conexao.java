package conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import exception.ErroSistema;

public class conexao {
	private static Connection con;
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/Rendas";
	private static final String USER = "root";
	private static final String PASS = "";
	private static final String ERROCON = "Impossível conectar ao Banco de Dados !!";
	private static final String ERRODRV = "Driver do Banco não foi encontrado!!!";
	private static final String ERROCLS = "Erro no fechamento da conexão!!";
	
	public static Connection getConnection() throws ErroSistema, SQLException {
		if(con == null || con.isClosed()) {
			try {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(URL, USER, PASS);
			} catch (SQLException e) {
				throw new ErroSistema(ERROCON, e);
			} catch (ClassNotFoundException e) {
				throw new ErroSistema(ERRODRV, e);
			}
		}
		return con; 
	}
	
	public static void fechaconexao(Connection con) throws ErroSistema {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			throw new ErroSistema(ERROCLS, e);
		}
	}
	
	public static void fechaconexao(Connection con, PreparedStatement stmt) throws ErroSistema {
	
		fechaconexao(con);
		
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
	public static void fechaconexao(Connection con, PreparedStatement stmt, ResultSet rs) throws ErroSistema {
		
		fechaconexao(con, stmt);
		
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}

}
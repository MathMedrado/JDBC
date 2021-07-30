package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class BancoDeDados {
	private Connection conexao = null;
	private Statement statement = null;	
	private ResultSet resultset = null;
	
	public void conectar(){
	
		String URLDB = "jdbc:mysql://localhost:3306/testes";
		String usuario = "root";
		String senha = "marcospaulo14";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver).newInstance();
			this.conexao = DriverManager.getConnection(URLDB,usuario,senha);
			this.statement = this.conexao.createStatement();
			
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
			}
		}
	public boolean estaConectado() {
		if(this.conexao != null) {
			return true;
		}
		else {
			return false;
			}
		}
	public void listar() {
		try {
			String query = "Select * from pessoa;";
			this.resultset = this.statement.executeQuery(query);//apenas para querey retorna valor
			while(this.resultset.next()) {
				System.out.println("id: " + this.resultset.getString("id_pessoa") + " 	Nome: " + this.resultset.getString("nome")
				+ "		Idade: " + this.resultset.getString("idade") + "	Sexo: " + this.resultset.getString("sexo")
				+ "		Nacionalidade: " + this.resultset.getString("nacionalidade"));
			}
		}
		catch(Exception e){
			System.out.println("Erro" + e.getMessage());
			
		}
	}
		
	public void inserirPessoa(String nome,char sexo,int idade , String nacionalidade){
		try {
			String query = "INSERT INTO `testes`.`pessoa` (`nome`, `idade`, `sexo`, `nacionalidade`) VALUES ('"+ nome +"','"+idade+"','"+sexo+"','" + nacionalidade+"');";
			//INSERT INTO `testes`.`pessoa` (`nome`, `idade`, `sexo`, `nacionalidade`) VALUES ('Bruno Fernandes', '25', 'M', 'Português');
			this.statement.executeUpdate(query);//insert update e delet/ não retorna valor
		}
		catch(Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
		
	}
	public void updatePessoa(String nome,char sexo,int idade , String nacionalidade, int id){
		try {
			String query = "UPDATE `testes`.`pessoa` SET `nome` = '" + nome + "', `idade` = '" + idade+ "', `nacionalidade` = '"+ nacionalidade +"' WHERE (`id_pessoa` = '"+id+"');";
			this.statement.executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
		
	}
	public void apagarPessoa(int id) {
		try {
			String query = "delete from pessoa where id_pessoa = '"+ id+"';";
			this.statement.executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
		
	}
	
	public void desconectar() {
		try {
			
		}
		catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
		
	}
	

	}


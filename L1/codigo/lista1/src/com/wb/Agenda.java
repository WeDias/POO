package com.wb;

import java.sql.*;

public class Agenda {
	private Connection conn;
	private Statement stmt;
	private ResultSet res;
	
	public void conectar() throws ClassNotFoundException, SQLException{
		Class.forName("org.sqlite.JDBC");
		String url = "jdbc:sqlite:banco.db";
		this.conn = DriverManager.getConnection(url);
		this.stmt = conn.createStatement();
    }

	public void desconectar() throws SQLException {
		this.conn.close();
    }
	
	public void consultar(String sql) throws SQLException{
		this.res = this.stmt.executeQuery(sql);
    }
	
	public void cadastrarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
		conectar();
		String sql = "INSERT INTO clientes(nome, telefone, dataNasc, genero)" +
					 " VALUES(?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cliente.getNome());
		pstmt.setString(2, cliente.getTelefone());
		pstmt.setString(3, cliente.getDataNasc());
		pstmt.setString(4, cliente.getGenero());
		pstmt.executeUpdate();
		desconectar();
	}
	
	public void removerCliente(String id) throws SQLException, ClassNotFoundException {
		conectar();
		String sql = "DELETE FROM clientes WHERE idCliente == " + id;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		desconectar();
	}
	
	public void atualizarCliente(String id, Cliente cliente) throws SQLException, ClassNotFoundException {
		conectar();
		String sql2 = "UPDATE clientes SET nome = ?, telefone = ?, "+
				 	  "dataNasc = ?, genero = ? WHERE idCliente == ?";
		PreparedStatement pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1, cliente.getNome());
		pstmt.setString(2, cliente.getTelefone());
		pstmt.setString(3, cliente.getDataNasc());
		pstmt.setString(4, cliente.getGenero());
		pstmt.setString(5, id);
		pstmt.executeUpdate();
		desconectar();
	}
	
	public void cliente(String id) throws SQLException, ClassNotFoundException {
		conectar();
		consultar("SELECT * FROM clientes WHERE idCliente == " + id + " ORDER BY nome ASC");
		System.out.printf("%d %s %s %s %s\n",
				this.res.getInt("idCliente"),
				this.res.getString("nome"),
				this.res.getString("telefone"),
				this.res.getString("dataNasc"),
				this.res.getString("genero"));
		
		String sql = "SELECT t.nomeServ, count(t.nomeServ) AS num FROM tipoServ " +
					 "AS t INNER JOIN servPrest AS s on s.idCliente == " + id +
					 " AND t.idTipoServ == s.idTipoServ GROUP BY t.nomeServ";
		consultar(sql);
		System.out.println("--------- serviços usados ---------");
		while(this.res.next()) {
			System.out.printf("%s - %d\n", this.res.getString("nomeServ"), this.res.getInt("num"));
		}
		desconectar();
	}
	
	public void clientes() throws SQLException, ClassNotFoundException {
		clientes("X");
	}
	
	public void clientes(String genero) throws SQLException, ClassNotFoundException {
		conectar();
		consultar("SELECT * FROM clientes ORDER BY nome ASC");
		while(this.res.next()) {
			if(genero.contentEquals(this.res.getString("genero")) || genero.contentEquals("X")) {
				System.out.printf("%d %s %s %s %s\n",
						this.res.getInt("idCliente"),
						this.res.getString("nome"),
						this.res.getString("telefone"),
						this.res.getString("dataNasc"),
						this.res.getString("genero"));
			}
		}
		desconectar();
	}
	
	public void relatorios() throws ClassNotFoundException, SQLException {
		conectar();
		double idadeMedia;
		String maisUsado;
		
		String sqlMedia = "SELECT AVG(date('now') - dataNasc) AS media from clientes";
		
		String sqlMais = "SELECT t.nomeServ, COUNT(t.nomeServ) AS num FROM servPrest AS s " + 
						 "INNER JOIN tipoServ AS t WHERE s.idTipoServ = t.idTipoServ " + 
						 "GROUP BY t.nomeServ ORDER BY num DESC LIMIT 1";
		
		String sqlMaisG = "SELECT t.nomeServ, COUNT(t.nomeServ) AS num FROM servPrest AS s " +
						  "INNER JOIN tipoServ AS t INNER JOIN clientes AS c WHERE " +
						  "s.idTipoServ = t.idTipoServ AND c.genero = '%s' AND " +
						  "c.idCliente = s.idCliente GROUP BY t.nomeServ ORDER BY num DESC LIMIT 1";
		
		
		consultar(sqlMedia);
		idadeMedia = this.res.getDouble("media");
		System.out.printf("A MÉDIA DE IDADE DOS CLIENTES É: %.2f ANOS\n", idadeMedia);
		
		consultar(sqlMedia + " WHERE genero = 'M'");
		idadeMedia = this.res.getDouble("media");
		System.out.printf("A MÉDIA DE IDADE DOS HOMENS É: %.2f ANOS\n", idadeMedia);
		
		consultar(sqlMedia + " WHERE genero = 'F'");
		idadeMedia = this.res.getDouble("media");
		System.out.printf("A MÉDIA DE IDADE DAS MULHERES É: %.2f ANOS\n", idadeMedia);
		
		
		consultar(sqlMais);
		maisUsado = this.res.getString("nomeServ").toUpperCase();
		System.out.printf("O SERVIÇO MAIS USADO PELOS CLIENTES É: %s\n", maisUsado);
		
		consultar(String.format(sqlMaisG, "M"));
		maisUsado = this.res.getString("nomeServ").toUpperCase();
		System.out.printf("O SERVIÇO MAIS USADO PELOS HOMENS É: %s\n", maisUsado);
		
		consultar(String.format(sqlMaisG, "F"));
		maisUsado = this.res.getString("nomeServ").toUpperCase();
		System.out.printf("O SERVIÇO MAIS USADO PELAS MULHERES É: %s\n", maisUsado);
		
		desconectar();
	}
	
}

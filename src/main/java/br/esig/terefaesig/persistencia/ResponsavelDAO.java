package br.esig.terefaesig.persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.esig.tarefaesig.dominio.Responsavel;
import br.esig.tarefaesig.dominio.Tarefa;

public class ResponsavelDAO {


	private Conexao minhaConexao;
	private final String selectGeral = "select * from responsavel";
	private final String SelectPorId = "select * from responsavel where Id = ?";
	private final String insert = "INSERT INTO responsavel (nome) values (?)";
	private final String Excluir = "delete from responsavel where id = ?";
	private final String Alterar = "Update responsavel set Nome = ? where id = ?";
	
	public ResponsavelDAO() {
		minhaConexao = new Conexao ("jdbc:postgresql://localhost:5432/Tarefas_ESIG", "postgres", "abc123");	
	}
	
	public void Adicionar (Responsavel rsp) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(insert);
			instrucao.setString(1, rsp.getNome());
			instrucao.execute();
			minhaConexao.desconectar();
		}catch (Exception e) {
			System.out.println("Erro ResponsavelDAO.Adicionar: " + e.getMessage());
		}
	}
	
	public void Excluir (Responsavel rsp) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(Excluir);
			instrucao.setInt(1, rsp.getId());
			instrucao.execute();
			minhaConexao.desconectar();
		}catch (Exception e) {
			System.out.println("Erro ResponsavelDAO.Excluir: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<Responsavel> listar () {
		ArrayList<Responsavel> resultado = new ArrayList();
		
		try {
		minhaConexao.conectar();
		Statement instrucao = minhaConexao.getConexao().createStatement();
		ResultSet resultSet = instrucao.executeQuery(selectGeral);
		while(resultSet.next()) {
			Responsavel r = new Responsavel(resultSet.getInt("id"), resultSet.getString("nome"));

			resultado.add(r);
		}
		minhaConexao.desconectar();
		}catch (Exception e) {
			System.out.println("Erro ResponsavelDAO.Listar: " + e.getMessage());
		}
		return resultado;
	}
	
		
}
